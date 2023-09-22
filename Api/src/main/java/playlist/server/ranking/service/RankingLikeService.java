package playlist.server.ranking.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RankingLikeService {

    private final RedisTemplate<String, String> redisTemplate;

    public void incrementLikes(String rankingType, String boardId) {
        try {
            String countsKey = rankingType + "_LIKE_COUNTS";
            redisTemplate.opsForHash().increment(countsKey, boardId, 1L);
        } catch (Exception e) {
            throw new RuntimeException("좋아요 증가 실패");
        }
    }
}
