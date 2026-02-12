package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import config.ConfigReader;

public class ConfigManagerTest {
	@Test(priority=1)
	public void defaultShouldBeChrome() {
	    String browser = ConfigReader.get("browser");
	    System.out.println("browser :"+browser);
	    System.out.println("Type :"+browser.getClass());
	    Assert.assertEquals(browser, "chrome");
	}

	@Test(priority=2)
	public void defaultHeadless() {
	    boolean headless = ConfigReader.getBoolean("headless");
	    System.out.println("headless :"+headless);
	    //System.out.println("Type :"+headless.getClass());
	    Assert.assertFalse(headless);  // FIXED
	}

	@Test(priority=3)
	public void defaultSlackWebhook() {
	    boolean slackHook = ConfigReader.getBoolean("slack.webhook");
	    System.out.println("slackHook :"+slackHook);
	    //System.out.println("Type :"+slackHook.getClass());
	    Assert.assertTrue(slackHook);
	}
	



}
