package playlist.server.ranking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RankingViewService {

    private final RedisTemplate<String, String> redisTemplate;

    public void incrementViews(String rankingType, String boardId) {
        try {
            String countsKey = rankingType + "_VIEW_COUNTS";
            redisTemplate.opsForHash().increment(countsKey, boardId, 1L);
        } catch (Exception e) {
            throw new RuntimeException("조회수 증가 실패");
        }
    }
}
