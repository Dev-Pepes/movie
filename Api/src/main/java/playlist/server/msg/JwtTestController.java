package playlist.server.msg;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import playlist.server.properties.JwtProperties;

@RequiredArgsConstructor
@RestController
@RequestMapping("/jwt")
public class JwtTestController {
    private final JwtProperties jwtProperties;

    @GetMapping
    public String jwtToString() {
        return jwtProperties.getIssuer();
    }
}
