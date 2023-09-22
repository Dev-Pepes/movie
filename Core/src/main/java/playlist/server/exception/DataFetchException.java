package playlist.server.exception;

public class DataFetchException extends BaseException {

    public static final BaseException EXCEPTION = new DataFetchException();

    public DataFetchException() {
        super(GlobalException.DATA_FETCH_ERROR);
    }
}
