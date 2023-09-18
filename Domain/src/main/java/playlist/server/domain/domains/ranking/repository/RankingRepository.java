package playlist.server.domain.domains.ranking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import playlist.server.domain.domains.ranking.domain.Ranking;
import playlist.server.domain.domains.ranking.domain.RankingInfo;


public interface RankingRepository extends JpaRepository<Ranking, Long> {
    Ranking findByRankingInfo(RankingInfo rankingInfo);
}
