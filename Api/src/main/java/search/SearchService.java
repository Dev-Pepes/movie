package search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    private SearchRepository searchRepository;

    @Autowired
    private SearchAdapter searchAdapter;

    public List<SearchResult> searchByTag(String tag) {
        // 태그를 기반으로 검색 결과를 데이터베이스에서 조회
        List<SearchEntity> searchEntities = searchRepository.findByTag(tag);

        // 검색 결과를 SearchAdapter를 사용하여 SearchResult로 변환
        List<SearchResult> searchResults = searchAdapter.adaptSearchResults(searchEntities);

        return searchResults;
    }

    public List<String> autoComplete(String query) {
        // 자동완성을 위해 데이터베이스에서 검색
        List<SearchEntity> searchEntities = searchRepository.findByTitleStartingWith(query);

        // 검색 결과 중 타이틀만 추출하여 자동완성 제안 목록 생성
        List<String> suggestions = searchEntities.stream()
                .map(SearchEntity::getTitle)
                .toList();

        return suggestions;
    }
}
