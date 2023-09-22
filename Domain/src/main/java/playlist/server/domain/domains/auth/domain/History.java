package playlist.server.domain.domains.auth.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import playlist.server.domain.domains.AbstractTimeStamp;

@Getter
@Entity
@Table(name = "tbl_user_login_history")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class History extends AbstractTimeStamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
