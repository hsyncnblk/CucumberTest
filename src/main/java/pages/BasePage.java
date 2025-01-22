package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Log;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // PageFactory ile sayfa elemanlarını başlatıyoruz
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement element) {
        try {
            WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));
            clickableElement.click();
            Log.info("Element clicked: " + clickableElement.toString());

        } catch (Exception e) {
            Log.error("Click error: " + element.toString() + " - " + e.getMessage());
        }
    }

    public void write(WebElement element, String text) {
        try {

            WebElement writableElement = wait.until(ExpectedConditions.elementToBeClickable(element));

            writableElement.sendKeys(text);
            Log.info("Text entered: " + text + " into element: " + writableElement.toString());
            Thread.sleep(1500);

        } catch (Exception e) {
            Log.error("Text entry error: " + element.toString() + " - " + e.getMessage());
        }
    }

    public void clickElement(WebElement element) {
        try {
            WebElement t = wait.until(ExpectedConditions.elementToBeClickable(element));

            t.click();
            Log.info("Element clicked: " + t.toString());

            Thread.sleep(3000);

        } catch (Exception e) {
            Log.error("Click error: " + element.toString() + " - " + e.getMessage());
        }
    }

    public void sendKeys(WebElement element, String text) {
        try {

            WebElement t = wait.until(ExpectedConditions.elementToBeClickable(element));

            t.sendKeys(text);
            Log.info("Text entered: " + text + " into element: " + element.toString());
            Thread.sleep(1500);

        } catch (Exception e) {
            Log.error("Text entry error: " + element.toString() + " - " + e.getMessage());
        }
    }

    public void actionsMove(WebElement element) {
        try {
            WebElement t = wait.until(ExpectedConditions.elementToBeClickable(element));

            actions.moveToElement(t).perform();
            Log.info("Hovered over  "   + element.toString());

        } catch (Exception e) {
            Log.error("Hover error: " + e.getMessage());
        }
    }

    public void thread() {
        try{
            Thread.sleep(5);

        }catch (Exception e){

        }
    }

    public void waitForPageToLoad() {
        wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
        Log.info("Sayfa tamamen yüklendi.");
    }




}
