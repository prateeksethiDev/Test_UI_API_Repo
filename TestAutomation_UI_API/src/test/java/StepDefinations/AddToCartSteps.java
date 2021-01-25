package StepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CartPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import testBase.TestBase;

public class AddToCartSteps {
	
	HomePageObjects homePage= new HomePageObjects();
	CartPageObjects cartPage = new CartPageObjects();
	LoginPageObjects loginPage= new LoginPageObjects();
	String titleOfLoginPage=null;
	
		
	@Given("User is on Home Page")
	public void user_is_on_home_page() throws Exception {	
		homePage.clickOnHomeMenu();
		homePage.checkIfHomePageIsOpen();	
	}

	@When("User is navigated to Laptop")
	public void user_is_navigated_to_laptop() {
		homePage.clickOnLaptopsCategory();
	}

	@When("^User select (.*)$")
	public void user_select_laptop(String product_name) {
		homePage.selectLaptop(product_name);
	}

	@When("Click on add to cart and accept confirmation popup")
	public void click_on_add_to_cart() {
	    homePage.clickOnAddToCart();
	}

	@Then("^Item (.*) should be added in the cart$")
	public void item_should_be_added_in_the_cart(String product_name) {
		homePage.clickOnCartMainMenu();
		cartPage.validateUserOnCartPage();
		cartPage.validateItemAddedOnCart(product_name);
	}
}