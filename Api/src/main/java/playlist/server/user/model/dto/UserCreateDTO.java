package playlist.server.user.model.dto;


import lombok.Getter;

@Getter
public class UserCreateDTO {
    private final String email;
    private final String password;

    // @QueryProjection
    public UserCreateDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
