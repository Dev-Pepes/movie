package playlist.server.domain.domains.board.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import playlist.server.domain.domains.AbstractTimeStamp;

@Entity
@Getter
@Table(name = "tbl_board")
@NoArgsConstructor
public class Board extends AbstractTimeStamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull private String name;

    @Enumerated(EnumType.STRING)
    private BoardType boardType;

    private String description;

    // TODO: created_user, updated_user 컬럼 나중에 추가해주기

    @OneToMany(mappedBy = "board", orphanRemoval = true)
    private List<Article> articleList = new ArrayList<>();
}
