package playlist.server.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@Getter
@RefreshScope
@AllArgsConstructor
@ConfigurationProperties(prefix = "spring.redis")
public class RedisProperties {
  private String host;
  private int port;
}
