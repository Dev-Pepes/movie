package playlist.server.mainpagerankingInfo.vo;

import lombok.Builder;
import lombok.Getter;
import playlist.server.domain.domains.ranking.domain.RankingInfo;
import playlist.server.domain.domains.ranking.domain.RankingType;

import java.util.List; // 추가

@Getter
@Builder
public class MainPageRankingInfoVo {
    private final RankingInfo rankingInfo;
    private final RankingType rankingType;
    private final List<RankingInfo> rankingInfoList;


    public static MainPageRankingInfoVo from(RankingInfo rankingInfo, RankingType rankingType, List<RankingInfo> rankingInfoList) {
        return MainPageRankingInfoVo.builder()
                .rankingInfo(rankingInfo)
                .rankingType(rankingType)
                .rankingInfoList(rankingInfoList)
                .build();
    }
}
