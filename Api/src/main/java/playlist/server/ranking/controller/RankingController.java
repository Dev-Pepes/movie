package playlist.server.ranking.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import playlist.server.domain.domains.ranking.domain.RankingInfo;
import playlist.server.domain.domains.ranking.domain.RankingType;
import playlist.server.ranking.service.RankingService;
import playlist.server.ranking.vo.ResponseRankingDto;

import java.util.List;

import static playlist.server.domain.domains.ranking.domain.RankingInfo.MONTH;
import static playlist.server.domain.domains.ranking.domain.RankingInfo.WEEK;
import static playlist.server.domain.domains.ranking.domain.RankingType.isStringLikeOrView;

@RestController
@RequestMapping("/ranking")
@RequiredArgsConstructor
@Tag(name = "1. [랭킹]")
public class RankingController {

    private final RankingService rankingService;

    @Operation(summary = "랭킹을 조회합니다.")
    @GetMapping("/daily")
    public ResponseEntity<List<ResponseRankingDto>> getDailyRanking(
            @RequestParam(name = "type", defaultValue = "like") String type) {
        return ResponseEntity.ok(getRanking(RankingInfo.DAILY, isStringLikeOrView(type)));
    }

    @Operation(summary = "주간 랭킹을 조회합니다.")
    @GetMapping("/weekly")
    public ResponseEntity<List<ResponseRankingDto>> getWeeklyRanking(
            @RequestParam(name = "type", defaultValue = "like") String type) {
        return ResponseEntity.ok(getRanking(WEEK, isStringLikeOrView(type)));
    }


    @Operation(summary = "월간 랭킹을 조회합니다.")
    @GetMapping("/monthly")
    public ResponseEntity<List<ResponseRankingDto>> getMonthlyRanking(
            @RequestParam(name = "type", defaultValue = "like") String type) {
        return ResponseEntity.ok(getRanking(MONTH, isStringLikeOrView(type)));
    }


    private List<ResponseRankingDto> getRanking(RankingInfo period, RankingType searchType) {
        return rankingService.getRankingList(period, searchType);
    }
}
