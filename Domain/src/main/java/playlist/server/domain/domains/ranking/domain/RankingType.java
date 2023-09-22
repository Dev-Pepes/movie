package playlist.server.domain.domains.ranking.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RankingType {
    LIKE("like"), //  좋아요 랭킹
    VIEW("view"); //  조회수 랭킹

    private final String description;

    /**
     * 문자열을 LIKE인지 확인한다, 아닌 경우에는 VIEW를 Return 한다.
     * @param type
     * @return
     */
    public static RankingType isStringLikeOrView(String type) {
        if(type.toLowerCase().equals(LIKE.description) ) {
            return LIKE;
        }
        return VIEW;
    }
}
