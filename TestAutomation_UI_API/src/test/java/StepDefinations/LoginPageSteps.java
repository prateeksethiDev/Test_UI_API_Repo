package StepDefinations;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;

public class LoginPageSteps {

	private LoginPageObjects loginPage= new LoginPageObjects();
	private HomePageObjects homePage= new HomePageObjects();
	private String titleOfLoginPage=null;
	
	@Given("User has already login in to the application")
	public void user_has_already_login(DataTable dataTable) {
		loginPage.verifyUserIsOnLoginPage();
		loginPage.clickOnLoginLink();
		List<Map<String, String>> credList=dataTable.asMaps();
		String userName=credList.get(0).get("username");
		String password=credList.get(0).get("password");
		loginPage.login(userName,password);
		homePage.checkIfHomePageIsOpen();
	}
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
		loginPage.verifyUserIsOnLoginPage();
	}

	@When("User gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		titleOfLoginPage=loginPage.getTitleOfLoginPage();
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String pageTitle) {
		loginPage.verifyTitleOfLoginPage(pageTitle);
	}
}
