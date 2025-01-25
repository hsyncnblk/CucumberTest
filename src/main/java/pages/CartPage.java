package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//body[1]/div[3]/div[1]/div[4]/div[1]/div[2]/div[2]/div[2]/div[6]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[3]/div[1]/p[4]")
    private WebElement name;



    public void verifyProduct(){

        WebElement renkElementi = driver.findElement(By.xpath("//span[@class='rd-cart-item-color']/strong"));
        WebElement selectedSizeProduct = driver.findElement(By.xpath("//span[@class='rd-cart-item-size']/strong"));
        WebElement quantityInput = driver.findElement(By.className("item-quantity-input"));
        WebElement productNameElement = driver.findElement(By.xpath("//span[@class='rd-cart-item-code']"));
        WebElement priceElement = driver.findElement(By.xpath("//span[@class='rd-cart-item-price mb-15']"));
        WebElement totalPriceElement = driver.findElement(By.xpath("//span[@class='total-grand-box-amount']"));


        String actualColor = renkElementi.getText().trim();
        String actualValue = quantityInput.getAttribute("value");
        String actualProductName = productNameElement.getText().trim();

        String actualSize = selectedSizeProduct.getText();

        String priceValue = priceElement.getText().trim();
        String totalPriceValue = totalPriceElement.getText().trim();




        //  Assert.assertEquals(actualSize, expectedSize);

        Assert.assertEquals("1",actualValue);

        Assert.assertTrue(actualColor.contains("Bej"));

        Assert.assertEquals(totalPriceValue , priceValue);

    }

    public void quantitiyTest() {
        try {
            WebElement quantityButton = driver.findElement(By.xpath("//a[starts-with(@id, 'Cart_AddQuantity_')]"));
            clickElement(quantityButton);
        } catch (Exception e) {
            Assert.fail("Ürün artırma butonu bulunamadı!");
        }
    }

    public void removeQuantityTest() {
        try {
            WebElement removeButton = driver.findElement(By.xpath("//a[starts-with(@id, 'Cart_RemoveQuantity_')]"));
            wait.until(ExpectedConditions.elementToBeClickable(removeButton));

            removeButton.click();
        } catch (Exception e) {
            Assert.fail("Ürün azaltma butonu bulunamadı!");
        }
    }



}
