package playlist.server.domain.domains.user.adaptor;


import lombok.RequiredArgsConstructor;
import playlist.server.annotation.Adaptor;
import playlist.server.domain.domains.user.Exception.UserNotFoundException;
import playlist.server.domain.domains.user.domains.User;
import playlist.server.domain.domains.user.repository.UserRepository;

@Adaptor
@RequiredArgsConstructor
public class UserAdaptor {
  
  private final UserAdaptor userAdaptor;
  private final UserRepository userRepository;
  
  public User query(Long userId) {
    return userRepository.findById(userId).orElseThrow(() -> UserNotFoundException.EXCEPTION);
  }
  
  public User save(User user) {
    return userRepository.save(user);
  }
}
