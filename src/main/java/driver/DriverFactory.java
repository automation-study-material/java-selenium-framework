package driver;
import config.ConfigReader;
import driver.provider.*;

public final class DriverFactory {

	public static void initDriver() {
		
		if (DriverManager.getDriver()!=null) {
			return;
		}
		DriverProvider provider;
		if (ConfigReader.getBoolean("run.remote"))
			provider = new RemoteDriverProvider();
		else
			provider = new LocalDriverProvider();
		DriverManager.setDriver(provider.createDriver());
	}
}
