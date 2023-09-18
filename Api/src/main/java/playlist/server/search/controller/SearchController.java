package playlist.server.search.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import playlist.server.search.service.SearchService;
import playlist.server.search.vo.SearchVo;

import java.util.List;

@RestController
@RequestMapping("/playlist/server/search")
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    // 태그 기반으로 검색
    @GetMapping("/tag")
    public ResponseEntity<List<SearchVo>> searchByTag(@RequestParam("tag") String tag) {
        List<SearchVo> searchResults = searchService.searchByTag(tag);

        if (searchResults.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(searchResults);
    }
}
