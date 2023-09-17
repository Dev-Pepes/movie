package playlist.server.domain.domains.playlist.domain;


import jakarta.persistence.Entity;
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
@Table(name = "tbl_playlist")
@NoArgsConstructor
public class Playlist extends AbstractTimeStamp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String thumbailLink;

    @NotNull private String playlistLink;

    private String countView;

    @OneToMany(mappedBy = "playlist", orphanRemoval = true)
    private List<PlaylistLike> likes = new ArrayList<>();
}
