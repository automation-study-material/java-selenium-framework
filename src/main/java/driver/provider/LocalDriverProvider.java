package driver.provider;
import config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.edge.*;

public class LocalDriverProvider implements DriverProvider {

    @Override
    public WebDriver createDriver() {

        String browser = ConfigReader.get("browser").toLowerCase();
        boolean headless = ConfigReader.getBoolean("headless");

        switch (browser) {

            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chrome = new ChromeOptions();
                if(headless) chrome.addArguments("--headless=new");
                return new ChromeDriver(chrome);

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefox = new FirefoxOptions();
                if(headless) firefox.addArguments("-headless");
                return new FirefoxDriver(firefox);

            case "edge":
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();

            default:
                throw new RuntimeException("Unsupported browser: " + browser);
        }
    }
}
