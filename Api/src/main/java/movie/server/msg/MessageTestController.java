package movie.server.msg;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message-test")
@RequiredArgsConstructor
public class MessageTestController {
    private final MessageTest messageTest;
/*
    public MessageTestController(MessageTest messageTest) {
        this.messageTest = messageTest;
    }*/

    @GetMapping
    public String LocalSetting() {
        return messageTest.toString();
    }
}
