package tests;

import base.BaseTest;
import config.ConfigReader;
import driver.DriverManager;
import oderflow.CustomerDetails;
import oderflow.ProductOrderData;
import utils.*;
import pages.HomePage;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {

	WebDriver driver;
	HomePage home;
    List<String> products;	
    
    @Test(priority=1)
    public void openGoogleHomePageTestOne() throws InterruptedException {
    	driver= DriverManager.getDriver();
    	HomePage homePage=new HomePage(driver);
        driver.get(homePage.getPageUrl());
        ProductOrderData data = JsonReader.getOrderData();
        products=data.getProductsToOrder();
        CustomerDetails customerDetails = data.getCustomerDetails();
        homePage.selectProduct("Samsung galaxy s6");
        Thread.sleep(2000);
    }
    
}
