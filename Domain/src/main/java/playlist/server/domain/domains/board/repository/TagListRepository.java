package playlist.server.domain.domains.board.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import playlist.server.domain.domains.board.domain.TagList;

public interface TagListRepository extends JpaRepository<TagList, Long> {}
