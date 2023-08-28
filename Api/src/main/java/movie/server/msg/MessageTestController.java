package movie.server.msg;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/message-test")
public class MessageTestController {
    
    private final MessageTest messageTest;

    @GetMapping
    public String LocalSetting() {
        return messageTest.toString();
    }
}
