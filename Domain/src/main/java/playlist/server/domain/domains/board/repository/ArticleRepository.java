package playlist.server.domain.domains.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import playlist.server.domain.domains.board.domain.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
