package stepDefinations;

import io.cucumber.java.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Log;
import utils.ScreenshotHelper;
import utils.WebDriverFactory;

import java.time.Duration;

public class Hooks {

    @BeforeAll
    public static void setUp() {
        Log.info("Test is starting...");
        WebDriverFactory.getDriver().get("https://www.lcw.com/");
        Log.info("Navigated to LCW home page.");

        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(5));

        // Cookies banner acceptance
        try {
            WebElement cookies = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cookieseal-banner")));
            WebElement cookiesBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookieseal-banner-accept")));
            if (cookies.isDisplayed()) {
                Log.info("Cookies banner is displayed, clicking accept...");
                cookiesBtn.click();
            }
        } catch (Exception e) {
            Log.info("Cookies banner is not displayed or already accepted.");
        }
    }



    @AfterStep
    public void takeScreenshotAfterStep(io.cucumber.java.Scenario scenario) {
        // Her adımda ekran görüntüsü almak için (isteğe bağlı)
        ScreenshotHelper.takeScreenshot(WebDriverFactory.getDriver(), "Step_" + scenario.getName());
    }

    @AfterAll
    public static void tearDown() {
        Log.info("Test is ending. Closing the browser...");
       // WebDriverFactory.closeDriver();
    }
}
