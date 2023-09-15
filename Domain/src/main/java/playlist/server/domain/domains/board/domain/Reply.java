package playlist.server.domain.domains.board.domain;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
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
@Table(name = "tbl_reply")
@NoArgsConstructor
public class Reply extends AbstractTimeStamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tbl_article_id")
    private Article article;

    private String content;

    @NotNull private Long userId;

    @OneToMany(mappedBy = "reply", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<ReplyLike> replyLikes = new ArrayList<>();

    @OneToMany(mappedBy = "reply", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<ReplyNotLike> replyNotLikes = new ArrayList<>();
}
