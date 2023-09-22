package playlist.server.ranking.service;


import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import playlist.server.domain.domains.ranking.domain.RankingInfo;
import playlist.server.exception.LikeIncrementException;
import playlist.server.exception.ViewIncrementException;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RankingViewService {

    private final RedisTemplate<String, String> redisTemplate;

    public List<RankingInfo> getViewRankingInfoList() {

        return Collections.emptyList();
    }

    public void incrementViews(String rankingType, String boardId) {
        try {
            String countsKey = rankingType + "_VIEW_COUNTS";
            redisTemplate.opsForHash().increment(countsKey, boardId, 1L);
        } catch (Exception e) {
            throw new ViewIncrementException();
        }
    }
}
