package tests;

import base.BaseTest;
import driver.DriverManager;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTestt extends BaseTest {

    @Test(priority=1)
    public void openGoogleHomePageTestOne() throws InterruptedException {
        WebDriver driver = DriverManager.getDriver();
        driver.get("https://www.google.com");
        Thread.sleep(2000);
        String title = driver.getTitle();
        System.out.println("Title: " + title);
        Assert.assertTrue(title.contains("Google"));
    }
    
    @Test(priority=2)
    public void openGoogleHomePageTestTwo() throws InterruptedException {
        WebDriver driver = DriverManager.getDriver();
        driver.get("https://www.google.com");
        Thread.sleep(2000);
        String title = driver.getTitle();
        System.out.println("Title: " + title);
        Assert.assertTrue(title.contains("Google"));
    }
    
    @Test(priority=3)
    public void openGoogleHomePageTestThree() throws InterruptedException {
        WebDriver driver = DriverManager.getDriver();
        driver.get("https://www.google.com");
        Thread.sleep(2000);
        String title = driver.getTitle();
        System.out.println("Title: " + title);
        Assert.assertTrue(title.contains("Google"));
    }
    
    @Test(priority=4)
    public void openGoogleHomePageTestFour() throws InterruptedException {
        WebDriver driver = DriverManager.getDriver();
        driver.get("https://www.google.com");
        Thread.sleep(2000);
        String title = driver.getTitle();
        System.out.println("Title: " + title);
        Assert.assertTrue(title.contains("Google"));
    }
}
