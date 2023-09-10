package playlist.server.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import playlist.server.properties.JwtProperties;
import playlist.server.properties.TenduckProperties;

@Configuration
@EnableConfigurationProperties({JwtProperties.class, TenduckProperties.class})
public class ConfigurationPropertiesConfig {
}
