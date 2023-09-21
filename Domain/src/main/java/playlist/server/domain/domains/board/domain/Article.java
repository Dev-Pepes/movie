package playlist.server.domain.domains.board.domain;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "tbl_article")
@NoArgsConstructor
public class Article extends AbstractTimeStamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tbl_article_id")
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boardId")
    private Board board;

    @NotNull private String title;

    @NotNull private String content;

    @NotNull private String articleType = board.getBoardType().getValue();

    @Enumerated(EnumType.STRING)
    private ArticleStatus articleStatus;

    @NotNull private Long createdUserId;

    @NotNull private Long updatedUserId;

    @OneToMany(
            mappedBy = "article",
            orphanRemoval = true,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Reply> replies = new ArrayList<>();

    @OneToMany(mappedBy = "article", orphanRemoval = true)
    private List<ArticleLike> likes = new ArrayList<>();

    @OneToMany(mappedBy = "article", orphanRemoval = true)
    private List<ArticleBookmark> bookmarks = new ArrayList<>();
}
