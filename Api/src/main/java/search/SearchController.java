package search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/tag")
    public ResponseEntity<List<SearchVo>> searchByTag(@RequestParam("tag") String tag) {
        List<SearchVo> searchResults = searchService.searchByTag(tag);

        if (searchResults.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(searchResults);
    }

    @GetMapping("/autocomplete")
    public ResponseEntity<List<String>> autoComplete(@RequestParam("query") String query) {
        List<String> suggestions = searchService.autoComplete(query);

        if (suggestions.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(suggestions);
    }
}
