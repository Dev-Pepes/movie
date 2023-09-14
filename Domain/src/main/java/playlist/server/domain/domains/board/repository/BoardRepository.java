package playlist.server.domain.domains.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import playlist.server.domain.domains.board.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
