package playlist.server.exception;

public class ExampleException extends BaseException {

    public static final BaseException EXCEPTION = new ExampleException();

    private ExampleException() {
        super(GlobalException.EXAMPLE_ERROR);
    }

    public static void main(String[] args) {
        throw ExampleException.EXCEPTION;
    }
}
