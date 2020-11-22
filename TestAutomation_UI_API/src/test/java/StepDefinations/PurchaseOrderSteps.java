package StepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CartPageObjects;
import pageObjects.HomePageObjects;

public class PurchaseOrderSteps {
	HomePageObjects homePage= new HomePageObjects();
	CartPageObjects cartPage = new CartPageObjects();
	
	@Given("User is present on cart page")
	public void user_is_on_cart_page() {
		homePage.clickOnCartMainMenu();
		cartPage.validateUserOnCartPage();
	}
	
	@Given("User clicks on place order button")
	public void user_clicks_on_placeOrderButton() {
		cartPage.clickPurchaseBtn();
	}
	
	@When("^User provided the customer name (.*)$")
	public void enterCustomerName(String customer_name) {
		cartPage.enterName(customer_name);
	}
	@When("^User provided the country (.*)$")
	public void enterCountry(String country) {
		cartPage.enterCountry(country);
	}
	@When("^User provided the city (.*)$")
	public void enterCity(String city) {
		cartPage.enterCity(city);
	}
	@When("^User provided the credit card (.*)$")
	public void enterCreditCard(String credit_card_number) {
		cartPage.enterCreditCard(credit_card_number);
	}
	@When("^User provided the month (.*)$")
	public void enterMonth(String month) {
		cartPage.enterMonth(month);
	}
	@When("^User provided the year (.*)$")
	public void enterYear(String year) {
		cartPage.enterYear(year);
	}
	@When("User clicks on purchase button")
	public void user_clicks_On_purchaseBtn() {
		cartPage.clickPurchaseBtn();
	}
	@When("Order should be placed successfully")
	public void Order_should_be_placed_successfully() {
		cartPage.assertConfirmationMessageExists();
	}
	@Then("^Amount of product should be (.*)$")
	public void verifyOrderAmount(String product_amount) {
		cartPage.validateOrderConfirmationMessage(product_amount);
	
	}
}
