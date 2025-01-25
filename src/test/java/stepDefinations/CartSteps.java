package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import pages.CartPage;
import pages.FilterPage;
import utils.WebDriverFactory;

public class CartSteps {

    CartPage cartPage = new CartPage(WebDriverFactory.getDriver());


    @Given("I verify the product details in the cart")
    @Step("Verify the product details in the cart")
    public void verifyProduct(){
        cartPage.verifyProduct();
        Allure.step("Product details verified in cart.");
    }

    @When("I increase the product quantity")
    @Step("Increase the product quantity")
    public void quantityProduct(){
        cartPage.quantitiyTest();
        Allure.step("Product quantity increased.");
    }

    @Then("I verify the product quantity is updated")
    @Step("Verify the product quantity is updated")
    public void updatedQuantity(){
        cartPage.removeQuantityTest();
        Allure.step("Product quantity updated and verified.");
    }
}
