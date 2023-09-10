package playlist.server.exception;

import playlist.server.dto.ErrorDetail;

public interface BaseErrorCode {
  
  public ErrorDetail getErrorDetail();
}
