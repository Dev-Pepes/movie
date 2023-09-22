package playlist.server.domain.domains.ranking.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RankingType {
    DAILY("일간"),
    WEEKLY("주간"),
    MONTHLY("월간"),
    LIKE("like"), //  좋아요 랭킹
    VIEW("view"); //  조회수 랭킹

    private final String description;

    public String getCountsKey() {
        return "like_" + this.name().toLowerCase() + "_counts";
    }

    public String getRankingKey() {
        return "like_" + this.name().toLowerCase() + "_ranking";
    }
}
