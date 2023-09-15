package ranking;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RankedPostVo {
    private final Long postId;
    private final int rank;

    public static RankedPostVo from(RankedPost rankedPost) {
        return RankedPostVo.builder()
                .postId(rankedPost.getPost().getId())
                .rank(rankedPost.getRank())
                .build();
    }
}
