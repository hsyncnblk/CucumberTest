package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FilterPage extends BasePage{



    public FilterPage(WebDriver driver) {
        super(driver);
    }



    @FindBy(xpath = "//a[contains(text(),'ÇOCUK & BEBEK')]")
    private WebElement childAndBaby;

    @FindBy(xpath = "//span[contains(text(),'KIZ ÇOCUK')]")
    private WebElement girlChild;

    @FindBy(linkText = "Mont ve Kaban")
    private WebElement coatJacket;


    @FindBy(xpath = "//span[contains(text(),'5-6 Yaş')]")
    private WebElement fiveSixAge;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[6]/div[1]/div[1]/div[1]/div[5]/div[1]/div[2]/div[3]/div[3]/div[1]/span[1]")
    private WebElement sixAge;

    @FindBy(xpath = "//span[contains(text(),'6-7 Yaş')]")
    private WebElement sixEightAge;


    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[6]/div[1]/div[1]/div[1]/div[5]/div[1]/div[2]/div[1]/input[1]") // Sol menü Xpath
    private WebElement serachBeden;
    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[6]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/div[3]/div[2]")
    private WebElement leftMenu;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[6]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]")
    private WebElement clickElement;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[6]/div[1]/div[1]/div[1]/div[6]/div[1]/div[2]/div[3]/div[2]")
    private WebElement bejColor;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[6]/div[1]/div[1]/div[1]/div[6]/div[1]/div[2]/div[1]/input[1]")
    private WebElement colorSearch;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[5]/div[1]/div[1]/div[1]/button[1]")
    private WebElement list;
    @FindBy(xpath = "//a[contains(text(),'En çok satanlar')]")
    private WebElement mostSales;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[6]/div[1]/div[2]/div[4]/a[1]/div[1]/img[1]")
    private WebElement fourthProduct;


    public void categoryScreen() {
        actionsMove(childAndBaby);

        actionsMove(girlChild);

        click(coatJacket);

    }

    public void filterFiveSixAge() {

        thread();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", leftMenu);
        thread();
        clickElement(fiveSixAge);
        waitForPageToLoad();

    }

    public void sixFilter(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", leftMenu);
        thread();
        clickElement(sixAge);

    }

    public void sixAndSevenFilter() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", leftMenu);

        sendKeys(serachBeden, "6-7 Yaş");
        wait.until(ExpectedConditions.visibilityOf(serachBeden));

        clickElement(sixEightAge);

    }


    public void setColor(){


        thread();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clickElement);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(colorSearch));

        waitForPageToLoad();

        thread();

        clickElement(bejColor);

        waitForPageToLoad();




        //url verify ve refresh
        //   Assert.assertEquals(driver.getCurrentUrl(), "https://www.lcw.com/kiz-cocuk-dis-giyim-t-1010?Sort=PersonalizationSorting&beden=5-6-yas,6-yas,6-7-yas&renk=bej");

        driver.navigate().to("https://www.lcw.com/kiz-cocuk-dis-giyim-t-1010?beden=5-6-yas,6-yas,6-7-yas&renk=bej");
        thread();
    }

    public void setSales(){


        clickElement(list);

        clickElement(mostSales);

        //click(fourthProduct);

     //   driver.navigate().refresh();
    }

}
