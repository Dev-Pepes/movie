package playlist.server.ranking.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import playlist.server.domain.domains.ranking.domain.RankingType;
import playlist.server.mainpagerankingInfo.vo.MainPageRankingInfoVo;
import playlist.server.domain.domains.ranking.domain.RankingInfo;
import playlist.server.exception.DataFetchException;
import playlist.server.exception.InvalidParameterException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RankingService {

    private final RankingLikeService rankingLikeService;
    private final RankingViewService rankingViewService;

    public MainPageRankingInfoVo getRanking(RankingType rankingType, String type, List<RankingInfo> rankingInfoList) {
        try {
            String rankingInfoKey = rankingType.getCountsKey();


            if (RankingType.LIKE.equals(rankingType) && "like".equals(type)) {
                List<RankingInfo> likeRankingInfoList = rankingLikeService.getLikeRankingInfoList(); // 랭킹 정보를 가져오는 메서드 호출
                rankingLikeService.incrementLikes(rankingInfoKey, boardId);
                return MainPageRankingInfoVo.from(null, rankingType, likeRankingInfoList);
            } else if (RankingType.VIEW.equals(rankingType) && "view".equals(type)) {
                List<RankingInfo> viewRankingInfoList = rankingViewService.getViewRankingInfoList(); // 랭킹 정보를 가져오는 메서드 호출
                rankingViewService.incrementViews(rankingInfoKey, boardId);
                return MainPageRankingInfoVo.from(null, rankingType, viewRankingInfoList);
            } else {
                throw new InvalidParameterException();
            }
            return MainPageRankingInfoVo.from(null, rankingType, rankingInfoList);
        } catch (Exception e) {
            throw new DataFetchException();
        }
    }
}
