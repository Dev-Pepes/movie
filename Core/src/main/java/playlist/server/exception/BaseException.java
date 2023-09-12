package playlist.server.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import playlist.server.dto.ErrorDetail;

@Getter
@AllArgsConstructor
public class BaseException extends RuntimeException {

    private BaseErrorCode errorCode;

    public ErrorDetail getErrorDetail() {
        return this.errorCode.getErrorDetail();
    }
}
