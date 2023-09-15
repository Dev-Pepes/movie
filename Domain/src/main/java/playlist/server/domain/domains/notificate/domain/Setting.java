package playlist.server.domain.domains.notificate.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.sql.Timestamp;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;
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

    boolean etc_param1;

    boolean etc_param2;

    boolean etc_param3;

    boolean etc_param4;

    boolean etc_param5;

    boolean etc_param6;

    boolean etc_param7;

    boolean etc_param8;

    boolean etc_param9;

    @Column(
            name = "updated_at",
            nullable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private Timestamp createdAt;
}
