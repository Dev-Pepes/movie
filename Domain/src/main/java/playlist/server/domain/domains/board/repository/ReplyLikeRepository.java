package playlist.server.domain.domains.board.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import playlist.server.domain.domains.board.domain.ReplyLike;

public interface ReplyLikeRepository extends JpaRepository<ReplyLike, Long> {}
