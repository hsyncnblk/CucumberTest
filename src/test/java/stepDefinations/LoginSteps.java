package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import pages.HomePage;
import pages.LoginPage;
import utils.WebDriverFactory;

public class LoginSteps{
    HomePage homePage = new HomePage(WebDriverFactory.getDriver());
    LoginPage loginPage = new LoginPage(WebDriverFactory.getDriver());


    @Step("Navigating to the login page")
    @Given("I navigate to loginPage")
    public void goToLoginPage() {
        homePage.loginScreen();
    }

    @Step("Entering a valid email: {0} and clicking on the {1} button")
    @When("I enter a valid {string} and click on the {string} button")
    public void enterValidMail(String email, String buttonName) {
        loginPage.enterMail("deneme@gmail.com");
    }

    @Step("Entering a valid password: {0} and clicking on the {1} button to log in")
    @And("I enter a valid {string} and click on the {string} button to log in")
    public void enterValidPassword(String password, String buttonName) {
        loginPage.enterPassword("password");
    }

    @Step("Verifying successful login and navigating to the home page")
    @Then("I should be logged in successfully")
    public void verifyLogin() {
        loginPage.goToHomePage();
    }

}
