package StepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import testBase.TestBase;

public class LoginSteps {
	LoginPageObjects loginPage= new LoginPageObjects();
	HomePageObjects homePage= new HomePageObjects();
	TestBase testBase = new TestBase();
	
	@Given("user is on login page")
	public void user_is_on_login_page() throws Exception {
	    System.out.println("User is navigating to Login Page");
	    testBase.launchApplication();
	}

	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String email,String password) {
		loginPage.enterUserName(email);
		loginPage.enterPassword(password);
	}

	@And("clicks on login button")
	public void clicks_on_login_button() {
		loginPage.clickLogin();
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
		homePage.checkIfDashboardPageIsOpen();
	}
}







