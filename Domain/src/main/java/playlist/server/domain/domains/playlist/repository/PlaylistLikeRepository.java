package playlist.server.domain.domains.playlist.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import playlist.server.domain.domains.playlist.domain.PlaylistLike;

public interface PlaylistLikeRepository extends JpaRepository<PlaylistLike, Long> {}
