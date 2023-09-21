package playlist.server.domain.domains.board.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import playlist.server.domain.domains.board.domain.HashTag;

public interface HashTagRepository extends JpaRepository<HashTag, Long> {}
