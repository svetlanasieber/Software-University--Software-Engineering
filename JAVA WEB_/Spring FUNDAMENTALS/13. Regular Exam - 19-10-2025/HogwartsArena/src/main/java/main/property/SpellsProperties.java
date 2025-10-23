package main.property;

import lombok.Data;
import main.config.YamlPropertySourceFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties
@PropertySource(value = "spells.yaml", factory = YamlPropertySourceFactory.class)
public class SpellsProperties {

    private List<SpellData> spells;

    @Data
    public static class SpellData {
        private String code;
        private String name;
        private String image;
        private String category;
        private String alignment;
        private int minLearned;
        private int power;
        private String description;
    }
}
