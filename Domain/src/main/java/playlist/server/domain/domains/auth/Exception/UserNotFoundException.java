package playlist.server.domain.domains.auth.Exception;


import playlist.server.exception.BaseException;

public class UserNotFoundException extends BaseException {
    public static final BaseException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException() {
        super(UserException.USER_NOT_FOUND_ERROR);
    }
}
