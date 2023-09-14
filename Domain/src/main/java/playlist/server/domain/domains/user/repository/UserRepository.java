package playlist.server.domain.domains.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import playlist.server.domain.domains.user.domains.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findUserByEmail(String email);
}
