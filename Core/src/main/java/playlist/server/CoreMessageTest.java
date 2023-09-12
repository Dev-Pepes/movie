package playlist.server;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Component
public class CoreMessageTest {
    @Value("${core.message}")
    private String message;

    @Override
    public String toString() {
        return "Core MessageTest{" + "message='" + message + '\'' + '}';
    }
}
