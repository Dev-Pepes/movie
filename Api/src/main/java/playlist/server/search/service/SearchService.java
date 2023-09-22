package playlist.server.search.service;


import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import playlist.server.domain.domains.search.repository.SearchRepository;
import playlist.server.search.vo.SearchVo;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final SearchRepository searchRepository;

    public List<SearchVo> searchByTag(String tag) {
        return searchRepository.findByTag(tag).stream()
                .map(search -> new SearchVo(search.getTitle(), search.getDescription()))
                .collect(Collectors.toList());
    }
}
