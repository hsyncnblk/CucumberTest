package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[contains(text(),'Giriş Yap')]")
    private WebElement loginButton;

    @FindBy(xpath ="//body/div[@id='root']/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]")
    private WebElement emailField;

    @FindBy(xpath ="//button[contains(text(),'Devam Et')]")
    private WebElement continueBtn;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/input[1]")
    private WebElement passwordField;

    @FindBy(xpath = "//button[contains(text(),'Giriş Yap')]")
    private WebElement loginBtn;

    public void enterMail(String email) {

        click(emailField);

        write(emailField,email);
        click(continueBtn);

    }

    public void enterPassword(String password) {

        click(passwordField);
        //wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(3));
        write(passwordField,password);

        clickElement(loginBtn);
    }

    public void goToHomePage(){
        driver.navigate().to("https://www.lcw.com/");
        thread();

        wait.until(ExpectedConditions.urlToBe(driver.getCurrentUrl()));

        Assert.assertEquals("https://www.lcw.com/", driver.getCurrentUrl());

    }

}
