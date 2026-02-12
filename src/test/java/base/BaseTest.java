package base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import driver.DriverFactory;
import driver.DriverManager;

public class BaseTest {

	
	@BeforeMethod
	public void setup() {
		DriverFactory.initDriver();
	}

	@AfterMethod
	public void tearDown() {
		DriverManager.quit();
	}
}
