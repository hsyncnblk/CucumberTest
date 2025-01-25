package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductDetailPage extends BasePage{
    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[contains(text(),'SEPETE EKLE')]")
    private WebElement addCart;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[6]/div[1]/div[2]/div[4]/a[1]/div[1]/img[1]")
    private WebElement fourthProduct;


    @FindBy(xpath = "//header/div[1]/div[3]/div[1]/div[2]/a[1]")
    private WebElement goToCart;

    private By sizeButtons = By.cssSelector("button[data-label]");


    public void goToDetail(){
        click(fourthProduct);

    }



    public void selectSize(){

        driver.navigate().refresh();
        List<WebElement> sizes = driver.findElements(sizeButtons);
        for (WebElement size : sizes) {
            if (size.isEnabled()) {
                size.click();
                break;
            }
        }

    }

    public void addToCart(){
        clickElement(addCart);
    }

    public void goToCart(){



        clickElement(goToCart);
    }

}
