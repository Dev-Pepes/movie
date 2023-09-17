package playlist.server.domain.domains.playlist.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import playlist.server.domain.domains.playlist.domain.PlaylistTaglist;

public interface PlaylistTaglistRepository extends JpaRepository<PlaylistTaglist, Long> {}
