package ranking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RankingService {

    private final RedisTemplate<String, String> redisTemplate;

    @Autowired
    public RankingService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    // 좋아요증가, 랭킹 업데이트 (일간)
    public void incrementDailyLikes(String boardId) {
        redisTemplate.opsForHash().increment("like_daily_counts", boardId, 1L);
        redisTemplate.opsForZSet().add("like_daily_ranking", boardId, (double) getCurrentLikes("like_daily_counts", boardId));
    }

    // // 좋아요증가, 랭킹 업데이트 (주간)
    public void incrementWeeklyLikes(String boardId) {
        redisTemplate.opsForHash().increment("like_weekly_counts", boardId, 1L);
        redisTemplate.opsForZSet().add("like_weekly_ranking", boardId, (double) getCurrentLikes("like_weekly_counts", boardId));
    }

    // // 좋아요증가, 랭킹 업데이트 (월간)
    public void incrementMonthlyLikes(String boardId) {
        redisTemplate.opsForHash().increment("like_monthly_counts", boardId, 1L);
        redisTemplate.opsForZSet().add("like_monthly_ranking", boardId, (double) getCurrentLikes("like_monthly_counts", boardId));
    }

    // 조회수 증가,  랭킹 업데이트 (일간)
    public void incrementDailyViews(String boardId) {
        redisTemplate.opsForHash().increment("view_daily_counts", boardId, 1L);
        redisTemplate.opsForZSet().add("view_daily_ranking", boardId, (double) getCurrentViews("view_daily_counts", boardId));
    }

    // 조회수 증가,  랭킹 업데이트 (주간)
    public void incrementWeeklyViews(String boardId) {
        redisTemplate.opsForHash().increment("view_weekly_counts", boardId, 1L);
        redisTemplate.opsForZSet().add("view_weekly_ranking", boardId, (double) getCurrentViews("view_weekly_counts", boardId));
    }

    // 조회수 증가,  랭킹 업데이트 (월간)
    public void incrementMonthlyViews(String boardId) {
        redisTemplate.opsForHash().increment("view_monthly_counts", boardId, 1L);
        redisTemplate.opsForZSet().add("view_monthly_ranking", boardId, (double) getCurrentViews("view_monthly_counts", boardId));
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
