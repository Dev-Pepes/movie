package playlist.server.config;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import playlist.server.dto.ErrorDetail;
import playlist.server.dto.ErrorResponse;
import playlist.server.exception.BaseErrorCode;
import playlist.server.exception.BaseException;
import playlist.server.exception.GlobalException;

import static playlist.server.exception.GlobalException.METHOD_ARGUMENT_ERROR;

@RestControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class GlobalExceptionHandler {
  
  @ExceptionHandler(BaseException.class)
  protected ResponseEntity<ErrorResponse> BaseExceptionHandle(
          BaseException e, HttpServletRequest request) {
    BaseErrorCode errorCode = e.getErrorCode();
    ErrorDetail errorDetail = errorCode.getErrorDetail();
    ErrorResponse errorResponse = new ErrorResponse(errorDetail);
    return ResponseEntity.status(HttpStatus.valueOf(errorDetail.getStatusCode())).body(errorResponse);
  }
  
  @ExceptionHandler(MethodArgumentNotValidException.class)
  protected ResponseEntity<ErrorResponse> ArgumentNotValidHandle(
          MethodArgumentNotValidException exception, HttpServletRequest request) {
    ErrorDetail errorDetail =
            ErrorDetail.builder()
                    .statusCode(METHOD_ARGUMENT_ERROR.getStatusCode())
                    .errorCode(METHOD_ARGUMENT_ERROR.getErrorCode())
                    .reason(
                            exception
                                    .getBindingResult()
                                    .getAllErrors()
                                    .get(0)
                                    .getDefaultMessage()
                    )
                    .build();
    ErrorResponse errorResponse = new ErrorResponse(errorDetail);
    return ResponseEntity.status(errorResponse.getStatusCode()).body(errorResponse);
  }
  
  @ExceptionHandler(Exception.class)
  protected ResponseEntity<ErrorResponse> internalServerExceptionHandle(
          Exception e, HttpServletRequest request) throws Exception {
    log.error(String.valueOf(e));
    GlobalException internalServerError = GlobalException.INTERNAL_SERVER_ERROR;
    ErrorResponse errorResponse = new ErrorResponse(internalServerError.getErrorDetail());
    return ResponseEntity.status(HttpStatus.valueOf(internalServerError.getStatusCode())).body(errorResponse);
  }
}
