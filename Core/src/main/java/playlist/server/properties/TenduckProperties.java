package playlist.server.properties;


import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@AllArgsConstructor
@ConfigurationProperties(prefix = "tenduck")
public class TenduckProperties {
    private List<String> corsDomain;
    private SecurityProperties security;

    @Getter
    @Setter
    public static class SecurityProperties {
        private List<String> whitelist;
    }
}
