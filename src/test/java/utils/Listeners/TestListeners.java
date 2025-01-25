package utils.Listeners;

import com.relevantcodes.extentreports.LogStatus;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import io.cucumber.java.Scenario;
import utils.ExtentReports.ExtentManager;
import utils.ExtentReports.ExtentTestManager;
import utils.WebDriverFactory;
import utils.Log;

public class TestListeners implements ITestListener {

    // Helper Method to Capture Screenshots
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    // On Test Start
    @Override
    public void onTestStart(ITestResult result) {
        Log.info("Test started: " + result.getName());
        ExtentTestManager.startTest(result.getMethod().getMethodName(), "");
    }

    // On Test Success
    @Override
    public void onTestSuccess(ITestResult result) {
        Log.info("Test passed: " + result.getName());
        ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed successfully");
        saveScreenshotPNG(WebDriverFactory.getDriver());
    }

    // On Test Failure
    @Override
    public void onTestFailure(ITestResult result) {
        Log.info("Test failed: " + result.getName());
        if (WebDriverFactory.getDriver() != null) {
            saveScreenshotPNG(WebDriverFactory.getDriver());
        }
        ExtentTestManager.getTest().log(LogStatus.FAIL, "Test failed");
    }

    // On Test Skipped
    @Override
    public void onTestSkipped(ITestResult result) {
        Log.info("Test skipped: " + result.getName());
        ExtentTestManager.getTest().log(LogStatus.SKIP, "Test skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    // On Start of Test Context
    @Override
    public void onStart(ITestContext context) {
        Log.info("Test context started: " + context.getName());
        context.setAttribute("WebDriver", WebDriverFactory.getDriver());
    }

    // On Finish of Test Context
    @Override
    public void onFinish(ITestContext context) {
        Log.info("Test context finished: " + context.getName());
        ExtentTestManager.endTest();
        ExtentManager.getReporter().flush();
    }
}
