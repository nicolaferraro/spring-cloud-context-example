package other;

import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.MapPropertySource;

@Configuration
public class MyPropertiesConf {

    private static final Logger LOG = LoggerFactory.getLogger(MyPropertiesConf.class);

    @Bean
    public PropertySourceLocator myPropLocator() {
        LOG.info("------ My PropertySourceLocator created");
        return environment -> {
            Map<String, Object> props = new TreeMap<>();
            props.put("endpoints.restart.enabled", "true");
            props.put("bean.message", "World!");

            MapPropertySource myPropertySource = new MapPropertySource("myMap", props);
            return myPropertySource;
        };
    }

}
