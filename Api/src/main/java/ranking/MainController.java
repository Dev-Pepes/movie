package ranking;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
@RequiredArgsConstructor
@Tag(name = "1. [메인 페이지]")
public class MainController {
    private final RankingService rankingService;

    @Operation(summary = "일간/주간/월간 랭킹을 조회합니다.")
    @GetMapping("/ranking")
    public ResponseEntity<MainPageRankingInfoVo> getRanking(@RequestParam RankingType rankingType) {
        MainPageRankingInfoVo rankingInfo = rankingService.getRankingInfo(rankingType);

        if (rankingInfo == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(rankingInfo);
    }
}
