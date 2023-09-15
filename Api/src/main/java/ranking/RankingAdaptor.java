package ranking;

import lombok.RequiredArgsConstructor;
import playlist.server.annotation.Adaptor;

@Adaptor
@RequiredArgsConstructor
public class RankingAdaptor {
    private final RankingRepository rankingRepository;

    public Ranking queryByRankingType(RankingType rankingType) {
        return rankingRepository.findByRankingType(rankingType);
    }
}