package playlist.server.utils;

import lombok.RequiredArgsConstructor;
import playlist.server.config.security.SecurityUtils;
import playlist.server.domain.domains.user.adaptor.UserAdaptor;
import playlist.server.domain.domains.user.domains.User;

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
