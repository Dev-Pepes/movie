package playlist.server.domain.domains.auth.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import playlist.server.domain.domains.AbstractTimeStamp;

@Getter
@Entity
@Table(name = "user_login_history")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class History extends AbstractTimeStamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login_at", nullable = false)
    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private Timestamp loginAt;

    // 이 밑으로는 뭔가 기록할만한 요소 들

    @Column(nullable = false, length = 200)
    private String param1;

    @Column(nullable = false, length = 200)
    private String param2;

    @Column(nullable = false, length = 200)
    private String param3;

    @Column(nullable = false, length = 200)
    private String param4;

    @Column(nullable = false, length = 200)
    private String param5;
}
