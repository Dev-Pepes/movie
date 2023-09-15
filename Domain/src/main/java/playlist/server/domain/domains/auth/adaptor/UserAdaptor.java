package playlist.server.domain.domains.auth.adaptor;


import lombok.RequiredArgsConstructor;
import playlist.server.annotation.Adaptor;
import playlist.server.domain.domains.auth.Exception.UserNotFoundException;
import playlist.server.domain.domains.auth.domain.User;
import playlist.server.domain.domains.auth.repository.UserRepository;

@Adaptor
@RequiredArgsConstructor
public class UserAdaptor {

    private final UserRepository userRepository;

    public User query(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
