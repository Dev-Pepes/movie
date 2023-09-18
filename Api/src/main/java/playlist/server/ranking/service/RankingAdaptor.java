package playlist.server.ranking.service;

import lombok.RequiredArgsConstructor;
import playlist.server.annotation.Adaptor;
import playlist.server.domain.domains.ranking.domain.Ranking;
import playlist.server.domain.domains.ranking.domain.RankingInfo;
import playlist.server.domain.domains.ranking.repository.RankingRepository;

@Adaptor
@RequiredArgsConstructor
public class RankingAdaptor {
    private final RankingRepository rankingRepository;

    public Ranking queryByRankingInfo(RankingInfo rankingInfo) {
        return rankingRepository.findByRankingInfo(rankingInfo);
    }
}
