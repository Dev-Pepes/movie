package playlist.server.ranking.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.redis.core.ZSetOperations;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseRankingDto {
    private String boardId;
    private Long score;

    public static ResponseRankingDto convertToResponseRankingDto(ZSetOperations.TypedTuple typedTuple) {
        return ResponseRankingDto.builder()
                .boardId(typedTuple.getValue().toString())
                .score(typedTuple.getScore().longValue())
                .build();
    }

}


