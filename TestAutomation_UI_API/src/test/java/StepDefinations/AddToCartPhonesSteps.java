package StepDefinations;

import java.util.List;
import java.util.Map;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CartPageObjects;
import pageObjects.HomePageObjects;
import reusableComponents.ExcelReader;

public class AddToCartPhonesSteps {
	
	private HomePageObjects homePage= new HomePageObjects();
	private CartPageObjects cartPage = new CartPageObjects();
	private ExcelReader excelreader= new ExcelReader();
	
	@When("User add phone to cart from given sheetname {string} and rownumber {int}")
	public void user_add_phone_to_cart_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber) {
		List<Map<String, String>> listDataKV=excelreader.readDataFromExcel("./src/test/resources/testData.xlsx", sheetName);
		String productCategory=listDataKV.get(rowNumber).get("product_category");
		String product_name=listDataKV.get(rowNumber).get("product_name");
		homePage.clickOnCategory(productCategory);
		homePage.selectProduct(product_name);
		homePage.clickOnAddToCart();
	}

	@Then("Item should be added in the cart as given sheetname {string} and rownumber {int}")
	public void item_should_be_added_in_the_cart_as_given_sheetname_and_rownumber(String sheetName, Integer rowNumber) {
		List<Map<String, String>> listDataKV=excelreader.readDataFromExcel("./src/test/resources/testData.xlsx", sheetName);
		String product_name=listDataKV.get(rowNumber).get("product_name");
		homePage.clickOnCartMainMenu();
		cartPage.validateUserOnCartPage();
		cartPage.validateItemAddedOnCart(product_name);
	}

}
