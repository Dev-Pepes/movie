package playlist.server.domain.domains.board.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import playlist.server.domain.domains.board.domain.ArticleBookmark;

public interface ArticleBookmarkRepository extends JpaRepository<ArticleBookmark, Long> {}
