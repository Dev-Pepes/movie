package playlist.server.domain.domains.playlist.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import playlist.server.domain.domains.AbstractTimeStamp;

@Entity
@Getter
@Table(name = "pls_video")
@NoArgsConstructor
public class PlaylistVideo extends AbstractTimeStamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull private String title;

    // TODO: created_user 컬럼 나중에 추가해주기

    @NotNull private String thumbnailLink;

    private String countView;

    private String totalVideos;

    @NotNull private String videoPlaybackTime;
}
