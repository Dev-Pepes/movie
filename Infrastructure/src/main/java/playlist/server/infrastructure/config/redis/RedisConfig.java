package playlist.server.infrastructure.config.redis;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisKeyValueAdapter;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import playlist.server.properties.RedisProperties;

import java.time.Duration;

@Slf4j
@EnableRedisRepositories(
        basePackages = "playlist.server",
        enableKeyspaceEvents = RedisKeyValueAdapter.EnableKeyspaceEvents.ON_STARTUP
)
@Configuration
@RequiredArgsConstructor
public class RedisConfig {
  private final RedisProperties redisProperties;
  
  @Bean
  public RedisConnectionFactory redisConnectionFactory() {
    log.error("fucking Bong Redis : {}" , redisProperties.toString());
    
    RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration(redisProperties.getHost(), redisProperties.getPort());
    
    LettuceClientConfiguration clientConfiguration =
            LettuceClientConfiguration.builder()
                    .commandTimeout(Duration.ofSeconds(1))
                    .shutdownTimeout(Duration.ZERO)
                    .build();
    
    return new LettuceConnectionFactory(redisConfig, clientConfiguration);
  }
}
