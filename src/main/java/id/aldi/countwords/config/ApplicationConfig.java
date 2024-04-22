package id.aldi.countwords.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Slf4j
public class ApplicationConfig {

    public static final Properties properties;

    static {
        properties = new Properties();

        try {
            ClassLoader classLoader = ApplicationConfig.class.getClassLoader();
            InputStream applicationPropertiesStream = classLoader.getResourceAsStream("application.properties");
            properties.load(applicationPropertiesStream);
        } catch (IOException e) {
            log.error("[ERROR][Failed to load properties]", e);
            throw new RuntimeException(e);
        }
    }
}
