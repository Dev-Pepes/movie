package playlist.server.domain.domains.user.domain;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.jetbrains.annotations.NotNull;
import playlist.server.domain.domains.AbstractTimeStamp;

@Getter
@Entity
@Table(name = "user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends AbstractTimeStamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String email;

    @Column(nullable = false, length = 100)
    private String password;

    // @Embedded private Profile profile;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false, name = "role", columnDefinition = "varchar(32) default 'USER'")
    private AccountRole accountRole;

    @Enumerated(EnumType.ORDINAL)
    @Column(length = 32, nullable = false, columnDefinition = "varchar(32) default 'DEFAULT'")
    private LoginType loginType;

    @NotNull
    @Column(name = "fail_cnt", nullable = false)
    @ColumnDefault("0")
    private int failCnt;

    @NotNull
    @Column(name = "rank_id", nullable = false)
    @ColumnDefault("0")
    private int rankId;

    @NotNull
    @ColumnDefault("0")
    private int exp;

    @Column(name = "update_user")
    private long updateUser;

    @Builder
    public User(String email, String password, AccountRole role) {
        this.email = email;
        this.accountRole = role;
        this.password = password;
    }
}
