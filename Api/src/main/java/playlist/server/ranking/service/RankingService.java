package playlist.server.ranking.service;

import org.springframework.stereotype.Service;
import playlist.server.domain.domains.ranking.domain.RankingInfo;
import playlist.server.domain.domains.ranking.domain.RankingType;
import playlist.server.mainpagerankingInfo.vo.MainPageRankingInfoVo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RankingService {

    private final RankingLikeService rankingLikeService;
    private final RankingViewService rankingViewService;

    public MainPageRankingInfoVo getRanking(String rankingType, String type, String boardId) {
        try {
            RankingInfo rankingInfo;
            if ("daily".equalsIgnoreCase(rankingType)) {
                rankingInfo = RankingInfo.DAILY;
            } else if ("weekly".equalsIgnoreCase(rankingType)) {
                rankingInfo = RankingInfo.WEEKLY;
            } else if ("monthly".equalsIgnoreCase(rankingType)) {
                rankingInfo = RankingInfo.MONTHLY;
            } else {
                throw new IllegalArgumentException("유효하지 않은 랭킹 타입");
            }

            if ("like".equals(type)) {
                rankingLikeService.incrementLikes(rankingType, boardId);
            } else if ("view".equals(type)) {
                rankingViewService.incrementViews(rankingType, boardId);
            } else {
                throw new IllegalArgumentException("유효하지 않은 파라미터");
            }

            return MainPageRankingInfoVo.from(rankingInfo, RankingType.valueOf(rankingType.toUpperCase()));
        } catch (Exception e) {
            throw new RuntimeException("데이터 가져오는거 실패");
        }
    }
}
