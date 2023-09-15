package playlist.server.domain.domains.board.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import playlist.server.domain.domains.board.domain.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long> {}
