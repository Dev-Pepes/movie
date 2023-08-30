package playlist.server.msg;

import lombok.RequiredArgsConstructor;
import playlist.server.CoreMessageTest;
import playlist.server.DomainMessageTest;
import playlist.server.InfraMessageTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message-test")
@RequiredArgsConstructor
public class MessageTestController {
    private final MessageTest messageTest;
    private final InfraMessageTest infraMessageTest;
    private final CoreMessageTest coreMessageTest;
    private final DomainMessageTest domainMessageTest;

    @GetMapping("/api")
    public String apiSetting() {
        return messageTest.toString();
    }
    @GetMapping("/infra")
    public String infraSetting() {
        return infraMessageTest.toString();
    }
    @GetMapping("/core")
    public String coreSetting() {
        return coreMessageTest.toString();
    }
    @GetMapping("/domain")
    public String domainSetting() {
        return domainMessageTest.toString();
    }

}
