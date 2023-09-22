package playlist.server.exception;

public class ViewIncrementException extends BaseException {

    public static final BaseException EXCEPTION = new ViewIncrementException();

    public ViewIncrementException() {
        super(GlobalException.VIEW_INCREMENT_ERROR);
    }
}
