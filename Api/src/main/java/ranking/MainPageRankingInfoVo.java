package ranking;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class MainPageRankingInfoVo {
    private final RankingType rankingType;
    private final List<RankedPostVo> rankedPosts;

    public static MainPageRankingInfoVo from(Ranking ranking) {
        return MainPageRankingInfoVo.builder()
                .rankingType(ranking.getRankingType())
                .rankedPosts(ranking.getRankedPosts().stream()
                        .map(RankedPostVo::from)
                        .toList())
                .build();
    }
}
