package playlist.server.ranking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import playlist.server.domain.domains.ranking.domain.RankingInfo; // RankingInfo enum 추가

@Service
public class RankingViewService {

    private final RedisTemplate<String, String> redisTemplate;

    @Autowired
    public RankingViewService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    // 조회수 증가, 랭킹 업데이트 (일간)
    public void incrementViews(String boardId, RankingInfo rankingInfo) {
        redisTemplate.opsForHash().increment(rankingInfo.getCountsKey(), boardId, 1L);
        redisTemplate.opsForZSet().add(rankingInfo.getRankingKey(), boardId, (double) getCurrentViews(rankingInfo.getCountsKey(), boardId));
    }

    // 현재 게시물의 조회수를 가져오는 메서드
    private long getCurrentViews(String hash, String boardId) {
        Object views = redisTemplate.opsForHash().get(hash, boardId);
        if (views != null) {
            return (long) views;
        } else {
            return 0L;
        }
    }
}
