package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import utils.WebDriverFactory;

public class LoginSteps{
    HomePage homePage = new HomePage(WebDriverFactory.getDriver());
    LoginPage loginPage = new LoginPage(WebDriverFactory.getDriver());


    @Given("I navigate to loginPage")
    public void goToLoginPage() {
        homePage.loginScreen();
    }

    @When("I enter a valid {string} and click on the {string} button")
    public void enterValidMail(String email, String buttonName) {
        loginPage.enterMail("deneme@gmail.com");
    }

    @And("I enter a valid {string} and click on the {string} button to log in")
    public void enterValidPassword(String password, String buttonName) {
        loginPage.enterPassword("deneme");
    }

    @Then("I should be logged in successfully")
    public void verifyLogin() {
        loginPage.goToHomePage();
    }

}
