package driver.provider;

import org.openqa.selenium.WebDriver;

public interface DriverProvider {

	WebDriver createDriver();
}
