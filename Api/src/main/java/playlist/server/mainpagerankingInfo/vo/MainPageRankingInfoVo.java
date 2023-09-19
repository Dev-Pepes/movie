package playlist.server.mainpagerankingInfo.vo;

import lombok.Builder;
import lombok.Getter;
import playlist.server.domain.domains.ranking.domain.RankingInfo;
import playlist.server.domain.domains.ranking.domain.RankingType;

@Getter
@Builder
public class MainPageRankingInfoVo {
    private final RankingInfo rankingInfo;
    private final RankingType rankingType;

    public static MainPageRankingInfoVo from(RankingInfo rankingInfo, RankingType rankingType) {
        return MainPageRankingInfoVo.builder()
                .rankingInfo(rankingInfo)
                .rankingType(rankingType)
                .build();
    }
}
