package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import pages.CartPage;
import pages.FavoritePage;
import utils.WebDriverFactory;

public class FavoriteSteps {
    FavoritePage favoritePage = new FavoritePage(WebDriverFactory.getDriver());


    @Step("Adding product to favorites")
    @And("I add the product to favorites")
    public void verifyProduct(){
        favoritePage.addFavorite();
    }

    @Step("Verifying the product is added to favorites successfully")
    @And("I verify the product is successfully added to favorites")
    public void quantityProduct(){
        favoritePage.verifyFav();
    }

    @Step("Navigating to the cart")
    @Then("I go to the cart")
    public void updatedQuantity(){
        favoritePage.goCart();
    }
}
