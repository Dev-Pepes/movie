package playlist.server.ranking.service;

import playlist.server.domain.domains.ranking.domain.RankingInfo;
import playlist.server.domain.domains.ranking.domain.RankingType;
import playlist.server.ranking.vo.ResponseRankingDto;

import java.util.List;

public interface RankingService {

    List<ResponseRankingDto> getRankingList(RankingInfo period, RankingType type);

    void incrementCountProcess(RankingType type, String boardId);
}
