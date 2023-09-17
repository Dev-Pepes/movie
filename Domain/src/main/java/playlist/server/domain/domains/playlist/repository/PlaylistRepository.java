package playlist.server.domain.domains.playlist.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import playlist.server.domain.domains.playlist.domain.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {}
