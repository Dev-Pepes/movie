package playlist.server.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import playlist.server.dto.AccessTokenDetail;
import playlist.server.exception.ExpiredRefreshTokenException;
import playlist.server.exception.ExpiredTokenException;
import playlist.server.exception.InvalidTokenException;
import playlist.server.properties.JwtProperties;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import static playlist.server.consts.StaticVal.*;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {
  
  private final JwtProperties jwtProperties;
  
  private Jws<Claims> getJws(String token) {
    try {
      return Jwts.parserBuilder().setSigningKey(getSecretKey()).build().parseClaimsJws(token);
    } catch (ExpiredJwtException e) {
      throw ExpiredTokenException.EXCEPTION;
    } catch (Exception e) {
      throw InvalidTokenException.EXCEPTION;
    }
  }
  
  private Key getSecretKey() {
    return Keys.hmacShaKeyFor(jwtProperties.getSecretKey().getBytes(StandardCharsets.UTF_8));
  }
  
  private String buildAccessToken(
          Long id, Date issuedAt, Date accessTokenExpiresAt, String role) {
    final Key encodedKey = getSecretKey();
    return Jwts.builder()
            .setIssuer(jwtProperties.getIssuer())
            .setIssuedAt(issuedAt)
            .setSubject(id.toString())
            .claim(TOKEN_TYPE, ACCESS_TOKEN)
            .claim("role", role)
            .setExpiration(accessTokenExpiresAt)
            .signWith(encodedKey)
            .compact();
  }
  
  private String buildRefreshToken(
          Long id, Date issuedAt, Date refreshTokenExpiresAt) {
    final Key encodedKey = getSecretKey();
    return Jwts.builder()
            .setIssuer(jwtProperties.getIssuer())
            .setIssuedAt(issuedAt)
            .setSubject(id.toString())
            .claim(TOKEN_TYPE, ACCESS_TOKEN)
            .setExpiration(refreshTokenExpiresAt)
            .signWith(encodedKey)
            .compact();
  }
  
  public String generateAccessToken(Long id, String role) {
    final Date issuedAt = new Date();
    final Date accessTokenExpiresAt =
            new Date(issuedAt.getTime() + jwtProperties.getAccessExp() * 1000);
    return buildAccessToken(id, issuedAt, accessTokenExpiresAt, role);
  }
  
  public String generateRefreshToken(Long id) {
    final Date issuedAt = new Date();
    final Date refreshTokenExpiresAt =
            new Date(issuedAt.getTime() + jwtProperties.getRefreshExp() * 1000);
    return buildRefreshToken(id, issuedAt, refreshTokenExpiresAt);
  }
  
  public boolean isAccessToken(String token) {
    return getJws(token).getBody().get(TOKEN_TYPE).equals(ACCESS_TOKEN);
  }
  
  public boolean isRefreshToken(String token) {
    return getJws(token).getBody().get(TOKEN_TYPE).equals(REFRESH_TOKEN);
  }
  
  public AccessTokenDetail parseAccessToken(String token) {
    if (isAccessToken(token)) {
      Claims claims = getJws(token).getBody();
      return AccessTokenDetail.builder()
              .userId(Long.parseLong(claims.getSubject()))
              .role((String) claims.get("role"))
              .build();
    }
    throw InvalidTokenException.EXCEPTION;
  }
  
  public Long parseRefreshToken(String token) {
    try {
      if (isRefreshToken(token)) {
        Claims claims = getJws(token).getBody();
        return Long.parseLong(claims.getSubject());
      }
    } catch (ExpiredTokenException e) {
      throw ExpiredRefreshTokenException.EXCEPTION;
    }
    throw InvalidTokenException.EXCEPTION;
  }
  
  public Long getRefreshTokenTTlSecond() {
    return jwtProperties.getRefreshExp();
  }
  
  public Long getAccessTokenTTlSecond() {
    return jwtProperties.getAccessExp();
  }
  
  public Long getLeftAccessTokenTTLSecond(String token) {
    return getJws(token).getBody().getExpiration().getTime();
  }
}