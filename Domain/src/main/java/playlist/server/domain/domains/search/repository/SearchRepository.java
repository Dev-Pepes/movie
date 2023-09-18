package playlist.server.domain.domains.search.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import playlist.server.domain.domains.search.domain.Search;
import java.util.List;

public interface SearchRepository extends JpaRepository<Search, Long> {
    List<Search> findByTag(String tag);
}
