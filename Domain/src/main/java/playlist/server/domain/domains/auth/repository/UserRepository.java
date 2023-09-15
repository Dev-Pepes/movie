package playlist.server.domain.domains.auth.repository;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import playlist.server.domain.domains.auth.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);
}
