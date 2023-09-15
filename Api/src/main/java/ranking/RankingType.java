package ranking;

public enum RankingType {
    DAILY("일간"),
    WEEKLY("주간"),
    MONTHLY("월간");

    private final String description;

    RankingType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

