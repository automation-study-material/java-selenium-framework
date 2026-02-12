package config;

import java.io.InputStream;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ConfigReader {

	
    private static final Logger log =
            LoggerFactory.getLogger(ConfigReader.class);

    private static final String DEFAULT_PROPERTIES = "config.properties";

    private static final Properties properties = new Properties();

    // =========================================
    // Static block → runs once automatically
    // =========================================
    static {
        try (InputStream stream =
                     ConfigReader.class.getClassLoader()
                             .getResourceAsStream(DEFAULT_PROPERTIES)) {

            if (stream == null)
                throw new RuntimeException("config.properties not found");
            properties.load(stream);

            log.info("===== Default Config =====");
            properties.forEach((k,v) -> log.info("{}={}", k, v));
            log.info("===========================");
            // CLI override (-D)
            for (String key : properties.stringPropertyNames()) {
                String cli = System.getProperty(key);
                if (cli != null) {
                    properties.setProperty(key, cli);
                }
            }

            log.info("===== CLI Override Config =====");
            properties.forEach((k,v) -> log.info("{}={}", k, v));
            log.info("===========================");

        } catch (Exception e) {
            throw new RuntimeException("Failed to load config", e);
        }
    }

    private ConfigReader() {}

    // =========================================
    // Simple usage
    // =========================================
    public static String get(String key){
        return properties.getProperty(key);
    }

    public static int getInt(String key){
        return Integer.parseInt(get(key));
    }

    public static boolean getBoolean(String key){
        return Boolean.parseBoolean(get(key));
    }
}
