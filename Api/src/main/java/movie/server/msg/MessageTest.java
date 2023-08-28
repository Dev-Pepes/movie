package movie.server.msg;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Component
public class MessageTest {
    @Value("${message}")
    private String message;

    @Override
    public String toString() {
        return "MessageTest{" +
                "message='" + message + '\'' +
                '}';
    }
}
