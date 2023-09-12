package playlist.server.config.security;

import static org.springframework.http.HttpHeaders.LOCATION;
import static org.springframework.http.HttpHeaders.SET_COOKIE;

import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import playlist.server.properties.TenduckProperties;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class CorsConfig implements WebMvcConfigurer {
    private final TenduckProperties tenduckProperties;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        String[] allowedOriginArray = tenduckProperties.getCorsDomain().toArray(String[]::new);
        Arrays.stream(allowedOriginArray).forEach(url -> log.info("Allowed Origin URL : {}", url));
        registry.addMapping("/**")
                .allowedMethods("*")
                .allowedOriginPatterns(allowedOriginArray)
                .exposedHeaders(LOCATION, SET_COOKIE)
                .allowCredentials(true);
    }
}
