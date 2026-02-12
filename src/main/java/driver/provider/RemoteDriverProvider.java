package driver.provider;

import driver.config.BrowserStackConfigLoader;
import driver.config.BrowserStackYamlConfig;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class RemoteDriverProvider implements DriverProvider {

    @Override
    public WebDriver createDriver() {

        BrowserStackYamlConfig cfg = BrowserStackConfigLoader.get();

        MutableCapabilities caps =
                new MutableCapabilities(cfg.getCapabilities());

        MutableCapabilities opts =
                new MutableCapabilities(cfg.getOptions());

        opts.setCapability("userName", cfg.getBrowserstack().getUser());
        opts.setCapability("accessKey", cfg.getBrowserstack().getKey());

        caps.setCapability("bstack:options", opts);

        try {
            return new RemoteWebDriver(
                    new URL(cfg.getBrowserstack().getHub()),
                    caps
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
