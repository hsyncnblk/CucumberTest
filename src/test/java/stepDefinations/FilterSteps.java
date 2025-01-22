package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.FilterPage;
import utils.WebDriverFactory;

public class FilterSteps {

    FilterPage filterPage = new FilterPage(WebDriverFactory.getDriver());


    @Given("I am on the filter page")
    public void iAmOnTheFilterPage() {
        filterPage.categoryScreen();
    }

    @When("I filter products by age 5-6 Yaş")
    public void FilterProductsFiveAndSix() {
        filterPage.filterFiveSixAge();

    }

    @And("I filter products by age 6 Yaş")
    public void iFilterProductsSix() {
        filterPage.sixFilter();

    }

    @And("I filter products by age 6-7 Yaş")
    public void iFilterProductsSixAndSeven()  throws InterruptedException{
        filterPage.sixAndSevenFilter();
    }

    @And("I filter products by color {string}")
    public void iFilterProductsByColor() {

        filterPage.setColor();
    }
    @And("I filter products by most sales")
    public void iFilterProductsBySales() {

        filterPage.setSales();
    }


    @Then("I should see products filtered by age and color")
    public void iShouldSeeProductsFilteredByAgeAndColor() {

        Assert.assertEquals("https://www.lcw.com/kiz-cocuk-dis-giyim-t-1010?beden=5-6-yas,6-yas,6-7-yas&renk=bej&siralama=en-cok-satanlar", WebDriverFactory.getDriver().getCurrentUrl());
    }
}
