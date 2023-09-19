package playlist.server.domain.domains.ranking.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RankingInfo {
    DAILY("like_daily_counts", "like_daily_ranking"),
    WEEKLY("like_weekly_counts", "like_weekly_ranking"),
    MONTHLY("like_monthly_counts", "like_monthly_ranking");

    private final String countsKey;
    private final String rankingKey;
}
