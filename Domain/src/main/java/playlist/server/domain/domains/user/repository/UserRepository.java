package playlist.server.domain.domains.user.repository;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import playlist.server.domain.domains.user.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);
}
