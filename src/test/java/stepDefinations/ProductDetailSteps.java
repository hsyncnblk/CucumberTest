package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.junit.Assert;
import pages.ProductDetailPage;
import utils.WebDriverFactory;

public class ProductDetailSteps {

    ProductDetailPage productDetailPage = new ProductDetailPage(WebDriverFactory.getDriver());

    @Step("Navigating to the product detail page")
    @Given("I am on the product detail page")
    public void iAmOnTheProductDetailPage() {
        productDetailPage.goToDetail();
    }

    @Step("Selecting a size for the product")
    @When("I select a size for the product")
    public void iSelectASizeForTheProduct() {
        productDetailPage.selectSize();
    }

    @Step("Adding the product to the cart")
    @And("I add the product to the cart")
    public void iAddTheProductToTheCart() {
        productDetailPage.addToCart();
    }

    @Step("Verifying the product is in the cart")
    @Then("I should see the product in the cart")
    public void iShouldSeeTheProductInTheCart() {
        productDetailPage.goToCart();
    }

}
