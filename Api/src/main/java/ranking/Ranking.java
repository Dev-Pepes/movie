package ranking;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "tbl_ranking")
@NoArgsConstructor
public class Ranking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RankingType rankingType;
    // 일간, 주간, 월간 중 하나를 나타냄
    @OneToMany(mappedBy = "ranking", cascade = CascadeType.ALL)
    private List<RankedPost> rankedPosts = new ArrayList<>();
    // 랭킹에 속한 게시물 목록

    // 생성자, 게터, 세터 등 필요한 메서드를 추가
}
