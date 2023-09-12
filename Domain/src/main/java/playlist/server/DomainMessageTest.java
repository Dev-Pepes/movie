package playlist.server;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Component
public class DomainMessageTest {
    @Value("${domain.message}")
    private String message;

    @Override
    public String toString() {
        return "Domain MessageTest{" + "message='" + message + '\'' + '}';
    }
}
