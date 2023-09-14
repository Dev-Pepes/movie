package playlist.server.domain.domains.user.Exception;

import lombok.RequiredArgsConstructor;
import playlist.server.dto.ErrorDetail;
import playlist.server.exception.BaseErrorCode;
import static org.springframework.http.HttpStatus.*;

@RequiredArgsConstructor
public enum UserException implements BaseErrorCode {
  USER_NOT_FOUND_ERROR(NOT_FOUND.value(), "User_404_1", "유저를 찾을 수 없습니다.");
  
  private final Integer statusCode;
  private final String errorCode;
  private final String reason;
  
  @Override
  public ErrorDetail getErrorDetail() {
    return ErrorDetail.of(statusCode, errorCode, reason);
  }
}
