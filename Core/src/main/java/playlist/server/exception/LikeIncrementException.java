package playlist.server.exception;

public class LikeIncrementException extends BaseException {

    public static final BaseException EXCEPTION = new LikeIncrementException();

    public LikeIncrementException() {
        super(GlobalException.LIKE_INCREMENT_ERROR);
    }
}
