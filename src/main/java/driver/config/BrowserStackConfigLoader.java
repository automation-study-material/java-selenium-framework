package driver.config;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;

public class BrowserStackConfigLoader {

    private static BrowserStackYamlConfig config;

    static {
        try (InputStream is =
                BrowserStackConfigLoader.class.getClassLoader()
                        .getResourceAsStream("browserstack.yml")) {

            Yaml yaml = new Yaml();
            config = yaml.loadAs(is, BrowserStackYamlConfig.class);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static BrowserStackYamlConfig get() {
        return config;
    }
}
