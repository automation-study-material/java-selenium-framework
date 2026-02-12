package pages;

import org.openqa.selenium.WebDriver;
import utils.ElementActions;

public abstract class BasePage {

    protected WebDriver driver;
    protected ElementActions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.actions = new ElementActions(driver);
    }
    public abstract String getPageUrl();
    public abstract boolean isPageLoaded();
    public abstract boolean isCorrectpageTitle();
    public abstract boolean isCorrectPageUrl();
}
