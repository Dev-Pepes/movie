package playlist.server.domain.domains.ranking.domain;

public enum RankingInfo {
    DAILY("like_daily_counts", "like_daily_ranking"),
    WEEKLY("like_weekly_counts", "like_weekly_ranking"),
    MONTHLY("like_monthly_counts", "like_monthly_ranking");

    private final String countsKey;
    private final String rankingKey;

    RankingInfo(String countsKey, String rankingKey) {
        this.countsKey = countsKey;
        this.rankingKey = rankingKey;
    }

    public String getCountsKey() {
        return countsKey;
    }

    public String getRankingKey() {
        return rankingKey;
    }
}
