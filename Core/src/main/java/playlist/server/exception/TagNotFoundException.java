package playlist.server.exception;

import playlist.server.exception.BaseErrorCode;
import playlist.server.exception.BaseException;
import static org.springframework.http.HttpStatus.NOT_FOUND;

public class TagNotFoundException extends BaseException {

    public static final BaseException EXCEPTION = new TagNotFoundException();

    private TagNotFoundException() {
        super(GlobalException.TAG_NOT_FOUND);
    }
}

