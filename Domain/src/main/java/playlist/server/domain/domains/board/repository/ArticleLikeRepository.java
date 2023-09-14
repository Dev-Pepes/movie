package playlist.server.domain.domains.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import playlist.server.domain.domains.board.domain.ArticleLike;

public interface ArticleLikeRepository extends JpaRepository<ArticleLike, Long> {
}
