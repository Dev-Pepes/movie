package movie.server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Component
public class InfraMessageTest {
    @Value("${infrastructure.message}")
    private String message;

    @Override
    public String toString() {
        return "Infra MessageTest{" +
                "message='" + message + '\'' +
                '}';
    }
}
