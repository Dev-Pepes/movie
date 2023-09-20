package playlist.server.user.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import playlist.server.user.model.dto.UserCreateDTO;
import playlist.server.user.service.devLoginService;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final devLoginService devLoginService;

    @GetMapping("/create")
    public void createDevUser(@RequestParam String email, @RequestParam String password) {
        log.info("email, password : " + email + "  " + password);

        UserCreateDTO userCreateDTO = new UserCreateDTO(email, password);
        devLoginService.execute(userCreateDTO);

        // model.addAttribute("email", email);
        // model.addAttribute("password",password);

    }
}
