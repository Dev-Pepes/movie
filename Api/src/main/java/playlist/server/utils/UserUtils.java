package playlist.server.utils;


import lombok.RequiredArgsConstructor;
import playlist.server.config.security.SecurityUtils;
import playlist.server.domain.domains.auth.adaptor.UserAdaptor;
import playlist.server.domain.domains.auth.domain.User;

@RequiredArgsConstructor
public class UserUtils {

    private final UserAdaptor userAdaptor;

    public Long getUserId() {
        return SecurityUtils.getCurrentUserId();
    }

    public User getUser() {
        return userAdaptor.query(SecurityUtils.getCurrentUserId());
    }
}
