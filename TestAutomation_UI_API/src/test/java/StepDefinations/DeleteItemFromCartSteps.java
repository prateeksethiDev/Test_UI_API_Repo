package StepDefinations;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CartPageObjects;
import pageObjects.HomePageObjects;

public class DeleteItemFromCartSteps {
	HomePageObjects homePage= new HomePageObjects();
	CartPageObjects cartPage = new CartPageObjects();
	

	@When("User navigated to cart section")
	public void user_is_navigated_to_cart() {
		homePage.clickOnCartMainMenu();
		cartPage.validateUserOnCartPage();
	}

	@When("^User delete the (.*) from the cart$")
	public void user_deletes_product_from_cart(String product_name) {
		cartPage.deleteProductFromCart(product_name);
	}

	@Then("^Verify (.*) not availble in cart$")
	public void verify_item_in_cart(String product_name) {
		cartPage.validateDeletedFromCart(product_name);
	}
}