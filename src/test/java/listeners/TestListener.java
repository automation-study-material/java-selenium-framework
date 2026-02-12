package listeners;

import driver.DriverFactory;
import driver.DriverManager;

import org.openqa.selenium.*;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestListener implements ITestListener {

    // =========================================
    // Test Start
    // =========================================
    @Override
    public void onTestStart(ITestResult result) {
    	DriverFactory.initDriver();
    	DriverManager.getDriver();
        System.out.println("🚀 STARTED: " + result.getName());
    }

    // =========================================
    // Test Success
    // =========================================
    @Override
    public void onTestSuccess(ITestResult result) {

        System.out.println("✅ PASSED: " + result.getName());

        markBrowserStackStatus("passed",
                result.getName() + " passed successfully");
    }

    // =========================================
    // Test Failure
    // =========================================
    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("❌ FAILED: " + result.getName());

        takeScreenshot(result.getName());

        markBrowserStackStatus("failed",
                result.getThrowable().getMessage());
    }

    // =========================================
    // Test Skipped
    // =========================================
    @Override
    public void onTestSkipped(ITestResult result) {

        System.out.println("⚠️ SKIPPED: " + result.getName());

        markBrowserStackStatus("failed", "Test skipped");
    }

    // =========================================
    // Suite Start
    // =========================================
    @Override
    public void onStart(ITestContext context) {
        System.out.println("===== TEST EXECUTION STARTED =====");
    }

    // =========================================
    // Suite Finish
    // =========================================
    @Override
    public void onFinish(ITestContext context) {
        System.out.println("===== TEST EXECUTION FINISHED =====");
    }

    // =========================================
    // Screenshot Utility
    // =========================================
    private void takeScreenshot(String testName) {

        try {
            WebDriver driver = DriverManager.getDriver();

            if (driver == null) return;

            TakesScreenshot ts = (TakesScreenshot) driver;

            File src = ts.getScreenshotAs(OutputType.FILE);

            Path dest = Path.of(
                    "screenshots",
                    testName + "_" + System.currentTimeMillis() + ".png"
            );

            Files.createDirectories(dest.getParent());
            Files.copy(src.toPath(), dest);

            System.out.println("📸 Screenshot saved: " + dest);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // =========================================
    // BrowserStack Status Updater
    // =========================================
    private void markBrowserStackStatus(String status, String reason) {

        try {

            WebDriver driver = DriverManager.getDriver();

            if (driver == null) return;

            if (driver instanceof JavascriptExecutor js) {

                js.executeScript(
                        "browserstack_executor: {\"action\": \"setSessionStatus\", " +
                                "\"arguments\": {\"status\":\"" + status +
                                "\", \"reason\": \"" + reason + "\"}}"
                );
            }

        } catch (Exception ignored) {}
    }
}

