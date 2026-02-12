package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ElementActions {

    private WebDriver driver;
    private WaitUtils wait;

    public ElementActions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    // =========================
    // Basic Actions
    // =========================

    public void click(By locator) {
        wait.waitForClickable(locator);
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        wait.waitForVisible(locator);
        WebElement el = driver.findElement(locator);
        el.clear();
        el.sendKeys(text);
    }

    public void clear(By locator) {
        wait.waitForVisible(locator);
        driver.findElement(locator).clear();
    }

    // =========================
    // Getters
    // =========================

    public String getText(By locator) {
        wait.waitForVisible(locator);
        return driver.findElement(locator).getText();
    }

    public String getAttribute(By locator, String attr) {
        return driver.findElement(locator).getAttribute(attr);
    }

    // =========================
    // State checks
    // =========================

    public boolean isDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    public boolean isEnabled(By locator) {
        return driver.findElement(locator).isEnabled();
    }

    public boolean isSelected(By locator) {
        return driver.findElement(locator).isSelected();
    }

    // =========================
    // Checkbox helpers
    // =========================

    public void check(By locator) {
        if (!isSelected(locator)) {
            click(locator);
        }
    }

    public void uncheck(By locator) {
        if (isSelected(locator)) {
            click(locator);
        }
    }

    // =========================
    // Dropdown
    // =========================

    public void selectByText(By locator, String text) {
        wait.waitForVisible(locator);
        new Select(driver.findElement(locator)).selectByVisibleText(text);
    }

    public void selectByValue(By locator, String value) {
        new Select(driver.findElement(locator)).selectByValue(value);
    }

    public void selectByIndex(By locator, int index) {
        new Select(driver.findElement(locator)).selectByIndex(index);
    }

    // =========================
    // Mouse Actions
    // =========================

    public void hover(By locator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(locator)).perform();
    }

    public void doubleClick(By locator) {
        Actions actions = new Actions(driver);
        actions.doubleClick(driver.findElement(locator)).perform();
    }

    public void rightClick(By locator) {
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(locator)).perform();
    }

    // =========================
    // Scroll
    // =========================

    public void scrollIntoView(By locator) {
        WebElement el = driver.findElement(locator);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", el);
    }

    // =========================
    // JavaScript click (fallback)
    // =========================

    public void jsClick(By locator) {
        WebElement el = driver.findElement(locator);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", el);
    }

    // =========================
    // File Upload
    // =========================

    public void uploadFile(By locator, String path) {
        driver.findElement(locator).sendKeys(path);
    }

    // =========================
    // Generic find
    // =========================

    public WebElement find(By locator) {
        wait.waitForPresence(locator);
        return driver.findElement(locator);
    } 
}
