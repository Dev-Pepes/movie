package playlist.server.ranking.service;


import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import playlist.server.domain.domains.ranking.domain.RankingInfo;
import playlist.server.domain.domains.ranking.domain.RankingType;
import playlist.server.ranking.vo.ResponseRankingDto;

import java.util.Arrays;
import java.util.List;

/**
 * 참고한 Reference : https://cantcoding.tistory.com/82
 */
@Service
@RequiredArgsConstructor
public class RedisRankingService implements RankingService {

    private final RedisTemplate<String, String> redisTemplate;

    /**
     * 랭킹 리스트를 0~10까지 가져온다.
     * @param period
     * @param type
     * @return
     */
    @Override
    public List<ResponseRankingDto> getRankingList(RankingInfo period, RankingType type) {
        return redisTemplate.opsForZSet()
                .reverseRangeWithScores(getRankingTypeKey(period, type), 0, 10)
                .stream()
                .map(ResponseRankingDto::convertToResponseRankingDto).toList();
    }

    /**
     * Like, View의 Daily, Week, Month의 카운트를 모두 증가시킨다.
     *
     * @param type
     * @param boardId
     */
    @Override
    public void incrementCountProcess(RankingType type, String boardId) {
        Arrays.stream(RankingInfo.values()).forEach(period -> {
            if (isExistInRanking(period, type, boardId)) {
                incrementRankingCount(period, type, boardId);
            } else {
                addRanking(period, type, boardId);
            }
        });
    }


    /**
     * 현재 ZSet에 값이 존재하는지 확인한다.
     * @param period
     * @param type
     * @param boardId
     * @return
     */
    private boolean isExistInRanking(RankingInfo period, RankingType type, String boardId) {
        return redisTemplate.opsForZSet()
                .score(getRankingTypeKey(period, type), boardId) != null;
    }

    /**
     * 값이 존재하지 않는 경우 Default Value로 1을 제공한다.
     *
     * @param period
     * @param type
     * @param boardId
     */
    private void addRanking(RankingInfo period, RankingType type, String boardId) {
        redisTemplate.opsForZSet().add(getRankingTypeKey(period, type), boardId, 1);
    }

    /**
     * Zset에 존재하는 경우 해당 값을 증가시킨다
     *
     * @param period
     * @param type
     * @param boardId
     */
    private void incrementRankingCount(RankingInfo period, RankingType type, String boardId) {
        redisTemplate.opsForZSet()
                .incrementScore(getRankingTypeKey(period, type), boardId, 1);
    }

    /**
     * Type에 따라 Key를 다르게 가져온다.
     *
     * @param period
     * @param type
     * @return
     */
    private String getRankingTypeKey(RankingInfo period, RankingType type) {
        return RankingType.LIKE.equals(type) ? period.getLikeKey() : period.getViewKey();
    }
}
