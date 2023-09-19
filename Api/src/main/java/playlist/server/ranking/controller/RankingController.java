package playlist.server.ranking.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import playlist.server.mainpagerankingInfo.vo.MainPageRankingInfoVo;
import playlist.server.ranking.service.RankingService;

@RestController
@RequestMapping("/ranking")
@RequiredArgsConstructor
@Tag(name = "1. [랭킹]")
public class RankingController {

    private final RankingService rankingService;

    @Operation(summary = "랭킹을 조회합니다.")
    @GetMapping("/daily")
    public ResponseEntity<MainPageRankingInfoVo> getDailyRanking(
            @RequestParam(name = "type", defaultValue = "like") String type
    ) {
        try {
            MainPageRankingInfoVo rankingInfoVo = rankingService.getRanking("daily", type, "boardId");
            if (rankingInfoVo == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(rankingInfoVo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "주간 랭킹을 조회합니다.")
    @GetMapping("/weekly")
    public ResponseEntity<MainPageRankingInfoVo> getWeeklyRanking(
            @RequestParam(name = "type", defaultValue = "like") String type
    ) {
        try {
            MainPageRankingInfoVo rankingInfoVo = rankingService.getRanking("weekly", type, "boardId");
            if (rankingInfoVo == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(rankingInfoVo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "월간 랭킹을 조회합니다.")
    @GetMapping("/monthly")
    public ResponseEntity<MainPageRankingInfoVo> getMonthlyRanking(
            @RequestParam(name = "type", defaultValue = "like") String type
    ) {
        try {
            MainPageRankingInfoVo rankingInfoVo = rankingService.getRanking("monthly", type, "boardId");
            if (rankingInfoVo == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(rankingInfoVo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
