package playlist.server.search.service;

import org.springframework.stereotype.Service;
import playlist.server.domain.domains.search.domain.Search;
import playlist.server.domain.domains.search.repository.SearchRepository;
import playlist.server.search.vo.SearchVo;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {

    private final SearchRepository searchRepository;

    public SearchService(SearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }

    public List<SearchVo> searchByTag(String tag) {
        // 태그를 기반으로 검색 결과를 데이터베이스에서 조회
        List<Search> searchEntities = searchRepository.findByTag(tag);

        // 검색 결과를 SearchVo로 변환
        List<SearchVo> searchResults = searchEntities.stream()
                .map(search -> new SearchVo(search.getTitle(), search.getDescription()))
                .collect(Collectors.toList());

        return searchResults;
    }
}
