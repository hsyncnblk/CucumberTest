package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotHelper {

    public static void takeScreenshot(WebDriver driver, String fileName) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotPath = "src/test/resources/screenshots/" + fileName + "_" + timestamp + ".png";

        try {
            FileHandler.copy(screenshot, new File(screenshotPath));
            System.out.println("Screenshot saved successfully: " + screenshotPath);
        } catch (Exception e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }


}