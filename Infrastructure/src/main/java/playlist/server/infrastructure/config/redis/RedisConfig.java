package playlist.server.infrastructure.config.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisKeyValueAdapter;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import java.time.Duration;

@EnableRedisRepositories(
        basePackages = "playlist.server",
        enableKeyspaceEvents = RedisKeyValueAdapter.EnableKeyspaceEvents.ON_STARTUP
)
@Configuration
public class RedisConfig {
  
  @Value("10duck")
  private String host;
  
  @Value("6379")
  private int port;
  
  @Bean
  public RedisConnectionFactory redisConnectionFactory() {
    RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration(host, port);
    
    LettuceClientConfiguration clientConfiguration =
            LettuceClientConfiguration.builder()
                    .commandTimeout(Duration.ofSeconds(1))
                    .shutdownTimeout(Duration.ZERO)
                    .build();
    
    return new LettuceConnectionFactory(redisConfig, clientConfiguration);
  }
}
