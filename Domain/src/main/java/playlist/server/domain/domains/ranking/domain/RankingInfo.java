package playlist.server.domain.domains.ranking.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RankingInfo {
    DAILY("daily_like", "daily_view"),
    WEEK("week_like", "week_view"),
    MONTH("month_like", "month_view");

    private final String likeKey;
    private final String viewKey;
}
