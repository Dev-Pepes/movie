package playlist.server.domain.domains.playlist.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import playlist.server.domain.domains.playlist.domain.PlaylistVideo;

public interface PlaylistVideoRepository extends JpaRepository<PlaylistVideo, Long> {}
