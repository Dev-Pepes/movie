package playlist.server.domain.domains.search.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import playlist.server.domain.domains.search.domain.Search;

public interface SearchRepository extends JpaRepository<Search, Long> {
    List<Search> findByTag(String tag);
}
