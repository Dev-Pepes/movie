package playlist.server.user.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import playlist.server.domain.domains.user.adaptor.UserAdaptor;
import playlist.server.domain.domains.user.domain.AccountRole;
import playlist.server.domain.domains.user.domain.User;
import playlist.server.user.model.dto.UserCreateDTO;

@Service
@RequiredArgsConstructor
@Transactional
public class devLoginService {
    private final UserAdaptor userAdaptor;

    public void execute(UserCreateDTO userCreateDTO) {
        User user = User.builder()
                .email(userCreateDTO.getEmail())
                .password(userCreateDTO.getPassword())
                .role(AccountRole.ADMIN)
                .build();
        userAdaptor.save(user);
    }
}
