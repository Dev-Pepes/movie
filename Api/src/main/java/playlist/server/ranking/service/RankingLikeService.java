package playlist.server.ranking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import playlist.server.domain.domains.ranking.domain.RankingInfo; // RankingInfo enum 추가

@Service
public class RankingLikeService {

    private final RedisTemplate<String, String> redisTemplate;

    @Autowired
    public RankingLikeService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    // 좋아요 증가, 랭킹 업데이트 (일간)
    public void incrementLikes(String boardId, RankingInfo rankingInfo) {
        redisTemplate.opsForHash().increment(rankingInfo.getCountsKey(), boardId, 1L);
        redisTemplate.opsForZSet().add(rankingInfo.getRankingKey(), boardId, (double) getCurrentLikes(rankingInfo.getCountsKey(), boardId));
    }

    // 현재 게시물의 좋아요를 가져오는 메서드
    private long getCurrentLikes(String hash, String boardId) {
        Object likes = redisTemplate.opsForHash().get(hash, boardId);
        if (likes != null) {
            return (long) likes;
        } else {
            return 0L;
        }
    }
}
