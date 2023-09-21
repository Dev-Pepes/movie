package playlist.server.domain.domains.playlist.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import playlist.server.domain.domains.AbstractTimeStamp;
import playlist.server.domain.domains.board.domain.Article;
import playlist.server.domain.domains.board.domain.PlaylistTag;

@Entity
@Getter
@Table(name = "tbl_playlist")
@NoArgsConstructor
public class Playlist extends AbstractTimeStamp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "articleId")
    private Article article;

    // TODO: Video(5~6개정도의) 객체 생성 및 주입하기

    private String thumbailLink;

    @NotNull private String playlistLink;

    private int viewCount;

    @OneToMany(mappedBy = "playlist", orphanRemoval = true)
    private List<PlaylistLike> likes = new ArrayList<>();

    @OneToMany(mappedBy = "playlist", orphanRemoval = true)
    private List<PlaylistTag> tags = new ArrayList<>();
}
