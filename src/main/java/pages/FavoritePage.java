package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FavoritePage extends BasePage{
    public FavoritePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@productid]")
    private WebElement productLink;

    @FindBy(xpath = "//a[starts-with(@id, 'Cart_addFavorite_')]")
    private WebElement favoriteButton;

    @FindBy(xpath = "//span[contains(text(),'Favorilerim')]")
    private WebElement goToFav;


    public void addFavorite(){


        wait.until(ExpectedConditions.elementToBeClickable(favoriteButton));


        clickElement(favoriteButton);

    }

    public void verifyFav(){
        clickElement(goToFav);

        WebElement productTitle = driver.findElement(By.xpath("//h5[@class='product-card__title']"));
        // WebElement cartItemTitle = driver.findElement(By.xpath("//span[@class='rd-cart-item-title']"));

        WebElement productColor = driver.findElement(By.xpath("//span[@class='product-card__color-title']"));


        String productTitleText = productTitle.getText();
        String productColorText = productColor.getText();
        // String itemText = cartItemTitle.getText();

        //Assert.assertTrue(productTitleText.contains("Kapüşonlu Kız Çocuk"));

        Assert.assertTrue("renk bej değil", productColorText.contains("BEJ"));

    }

    public void goCart(){
        driver.navigate().to("https://www.lcw.com/sepetim");
    }
}
