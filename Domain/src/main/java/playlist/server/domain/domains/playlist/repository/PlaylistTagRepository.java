package playlist.server.domain.domains.playlist.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import playlist.server.domain.domains.playlist.domain.PlaylistTag;

public interface PlaylistTagRepository extends JpaRepository<PlaylistTag, Long> {}
