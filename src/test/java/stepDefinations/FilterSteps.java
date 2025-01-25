package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.junit.Assert;
import pages.FilterPage;
import utils.WebDriverFactory;

public class FilterSteps {

    FilterPage filterPage = new FilterPage(WebDriverFactory.getDriver());


    @Step("Navigating to the filter page")
    @Given("I am on the filter page")
    public void iAmOnTheFilterPage() {
        filterPage.categoryScreen();
    }

    @Step("Filtering products by age range 5-6 Yaş")
    @When("I filter products by age 5-6 Yaş")
    public void filterProductsByAgeFiveAndSix() {
        filterPage.filterFiveSixAge();
    }

    @Step("Filtering products by age 6 Yaş")
    @And("I filter products by age 6 Yaş")
    public void filterProductsByAgeSix() {
        filterPage.sixFilter();
    }

    @Step("Filtering products by age range 6-7 Yaş")
    @And("I filter products by age 6-7 Yaş")
    public void filterProductsByAgeSixAndSeven() throws InterruptedException {
        filterPage.sixAndSevenFilter();
    }

    @Step("Filtering products by color Bej")
    @And("I filter products by color Bej")
    public void filterProductsByColor() {
        filterPage.setColor();
    }

    @Step("Filtering products by most sales")
    @And("I filter products by most sales")
    public void filterProductsBySales() {
        filterPage.setSales();
    }

    @Step("Verifying the filtered products by age and color")
    @Then("I should see products filtered by age and color")
    public void iShouldSeeProductsFilteredByAgeAndColor() {
        String expectedUrl = "https://www.lcw.com/kiz-cocuk-dis-giyim-t-1010?beden=5-6-yas,6-yas,6-7-yas&renk=bej&siralama=en-cok-satanlar";
        String currentUrl = WebDriverFactory.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl, currentUrl);
    }
}



