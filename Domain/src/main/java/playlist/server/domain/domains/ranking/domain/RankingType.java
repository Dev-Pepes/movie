package playlist.server.domain.domains.ranking.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RankingType {
    DAILY("일간"),
    WEEKLY("주간"),
    MONTHLY("월간");

    private final String description;

}

