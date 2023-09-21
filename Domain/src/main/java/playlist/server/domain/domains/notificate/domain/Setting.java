package playlist.server.domain.domains.notificate.domain;


import jakarta.persistence.*;
import lombok.*;
import playlist.server.domain.domains.AbstractTimeStamp;

@Getter
@Entity
@Table(name = "setting")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Setting extends AbstractTimeStamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String email;

    //    boolean etc_param1;
    //
    //    boolean etc_param2;
    //
    //    boolean etc_param3;
    //
    //    boolean etc_param4;
    //
    //    boolean etc_param5;
    //
    //    boolean etc_param6;
    //
    //    boolean etc_param7;
    //
    //    boolean etc_param8;
    //
    //    boolean etc_param9;

}
