package playlist.server.search.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import playlist.server.search.service.SearchService;
import playlist.server.search.vo.SearchVo;

import java.util.List;

@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    // 태그 기반으로 검색
    @GetMapping("/tag")
    public ResponseEntity<List<SearchVo>> searchByTag(@RequestParam("tag") String tag) {
        List<SearchVo> searchResults = searchService.searchByTag(tag);

        if (searchResults.isEmpty()) {
            throw new IllegalArgumentException("해당 태그가 없다");
        }

        return ResponseEntity.ok(searchResults);
    }
}