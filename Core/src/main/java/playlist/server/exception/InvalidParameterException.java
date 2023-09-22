package playlist.server.exception;

public class InvalidParameterException extends BaseException {

    public static final BaseException EXCEPTION = new InvalidParameterException();

    public InvalidParameterException() {
        super(GlobalException.INVALID_PARAMETER_ERROR);
    }
}
