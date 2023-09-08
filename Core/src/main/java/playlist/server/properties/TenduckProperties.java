package playlist.server.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
@Getter
@AllArgsConstructor
@ConfigurationProperties(prefix = "tenduck")
public class TenduckProperties {
    private List<String> corsDomain;

}
