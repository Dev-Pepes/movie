package playlist.server.ranking.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import playlist.server.domain.domains.ranking.domain.RankingType;
import playlist.server.ranking.MainPageRankingInfoVo;
import playlist.server.ranking.service.RankingLikeService;
import playlist.server.ranking.service.RankingViewService;
import playlist.server.domain.domains.ranking.domain.RankingInfo; // RankingInfo enum 추가

@RestController
@RequestMapping("/ranking")
@RequiredArgsConstructor
@Tag(name = "1. [랭킹]")
public class RankingController {

    private final RankingLikeService rankingLikeService;
    private final RankingViewService rankingViewService;

    @Operation(summary = "일간 랭킹을 조회합니다.")
    @GetMapping("/daily")
    public ResponseEntity<MainPageRankingInfoVo> getDailyRanking(
            @RequestParam(name = "rankingType", required = false, defaultValue = "DAILY") RankingType rankingType) {
        RankingInfo rankingInfo = RankingInfo.DAILY;
        rankingLikeService.incrementLikes(rankingType.name(), rankingInfo);
        MainPageRankingInfoVo rankingInfoVo = MainPageRankingInfoVo.from(rankingInfo, rankingType);

        if (rankingInfoVo == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(rankingInfoVo);
    }

    @Operation(summary = "주간 랭킹을 조회합니다.")
    @GetMapping("/weekly")
    public ResponseEntity<MainPageRankingInfoVo> getWeeklyRanking(
            @RequestParam(name = "rankingType", required = false, defaultValue = "WEEKLY") RankingType rankingType) {
        RankingInfo rankingInfo = RankingInfo.WEEKLY;
        rankingLikeService.incrementLikes(rankingType.name(), rankingInfo);
        MainPageRankingInfoVo rankingInfoVo = MainPageRankingInfoVo.from(rankingInfo, rankingType);

        if (rankingInfoVo == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(rankingInfoVo);
    }

    @Operation(summary = "월간 랭킹을 조회합니다.")
    @GetMapping("/monthly")
    public ResponseEntity<MainPageRankingInfoVo> getMonthlyRanking(
            @RequestParam(name = "rankingType", required = false, defaultValue = "MONTHLY") RankingType rankingType) {
        RankingInfo rankingInfo = RankingInfo.MONTHLY;
        rankingLikeService.incrementLikes(rankingType.name(), rankingInfo);
        MainPageRankingInfoVo rankingInfoVo = MainPageRankingInfoVo.from(rankingInfo, rankingType);

        if (rankingInfoVo == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(rankingInfoVo);
    }

    @Operation(summary = "일간 조회수 랭킹을 조회합니다.")
    @GetMapping("/daily-views")
    public ResponseEntity<MainPageRankingInfoVo> getDailyViewsRanking(
            @RequestParam(name = "rankingType", required = false, defaultValue = "DAILY") RankingType rankingType) {
        RankingInfo rankingInfo = RankingInfo.DAILY;
        rankingViewService.incrementViews(rankingType.name(), rankingInfo);
        MainPageRankingInfoVo rankingInfoVo = MainPageRankingInfoVo.from(rankingInfo, rankingType);

        if (rankingInfoVo == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(rankingInfoVo);
    }

    @Operation(summary = "주간 조회수 랭킹을 조회합니다.")
    @GetMapping("/weekly-views")
    public ResponseEntity<MainPageRankingInfoVo> getWeeklyViewsRanking(
            @RequestParam(name = "rankingType", required = false, defaultValue = "WEEKLY") RankingType rankingType) {
        RankingInfo rankingInfo = RankingInfo.WEEKLY;
        rankingViewService.incrementViews(rankingType.name(), rankingInfo);
        MainPageRankingInfoVo rankingInfoVo = MainPageRankingInfoVo.from(rankingInfo, rankingType);

        if (rankingInfoVo == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(rankingInfoVo);
    }

    @Operation(summary = "월간 조회수 랭킹을 조회합니다.")
    @GetMapping("/monthly-views")
    public ResponseEntity<MainPageRankingInfoVo> getMonthlyViewsRanking(
            @RequestParam(name = "rankingType", required = false, defaultValue = "MONTHLY") RankingType rankingType) {
        RankingInfo rankingInfo = RankingInfo.MONTHLY;
        rankingViewService.incrementViews(rankingType.name(), rankingInfo);
        MainPageRankingInfoVo rankingInfoVo = MainPageRankingInfoVo.from(rankingInfo, rankingType);

        if (rankingInfoVo == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(rankingInfoVo);
    }
}