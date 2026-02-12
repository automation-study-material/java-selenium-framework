package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class WaitUtils {

    private WebDriver driver;
    private WebDriverWait wait;

    private static final int DEFAULT_TIMEOUT = 10;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
    }

    // =========================
    // Element waits
    // =========================

    public void waitForVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForPresence(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitForInvisibility(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitForTextToBePresent(By locator, String text) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    public void waitForAttributeContains(By locator, String attribute, String value) {
        wait.until(ExpectedConditions.attributeContains(locator, attribute, value));
    }

    // =========================
    // Page waits
    // =========================

    public void waitForTitleContains(String title) {
        wait.until(ExpectedConditions.titleContains(title));
    }

    public void waitForUrlContains(String partialUrl) {
        wait.until(ExpectedConditions.urlContains(partialUrl));
    }

    // =========================
    // Alert & Frame waits
    // =========================

    public void waitForAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void waitForFrameAndSwitch(By locator) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }

    // =========================
    // Custom timeout method
    // =========================

    public void waitForVisible(By locator, int seconds) {
        new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
