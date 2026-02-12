package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import config.ConfigReader;
import utils.ElementActions;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
        super(driver);
    }

	private static final String PRODUCT = "//*[text()='%s']";
	
	
	private By getProductName(String name) {
	    return By.xpath(String.format(PRODUCT, name));
	}

    public void selectProduct(String productName) {
        actions.click(getProductName(productName));
    }

    public boolean isProductVisible(String name) {
        return actions.isDisplayed(getProductName(name));
    }

	@Override
	public boolean isPageLoaded() {
		
		return false;
	}

	@Override
	public boolean isCorrectpageTitle() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCorrectPageUrl() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getPageUrl() {
		String urlString="";
		if (ConfigReader.getBoolean("prod")) {
			System.out.println("PROD URL");
			urlString="https://demoblaze.com/";
		}else {
			System.out.println("STAGE URL");
			urlString="https://demoblaze.com/";
		}
		return urlString;
	}


}
