package playlist.server.domain.domains.user.Exception;


import lombok.RequiredArgsConstructor;
import playlist.server.exception.BaseException;

@RequiredArgsConstructor
public class UserNotFoundException extends BaseException {
    public static final BaseException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException() {
        super(UserException.USER_NOT_FOUND_ERROR);
    }
}
