package playlist.server.domain.domains.board.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import playlist.server.domain.domains.board.domain.ArticleTag;

public interface ArticleTagRepository extends JpaRepository<ArticleTag, Long> {}
