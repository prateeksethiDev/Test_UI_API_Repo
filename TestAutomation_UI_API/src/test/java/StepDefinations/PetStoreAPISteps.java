package StepDefinations;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import reusableComponents.RestAssuredExtension;

public class PetStoreAPISteps {
	private static ResponseOptions<Response>response;
	
	@Given("I perform GET operation for {string} for {string} pets")
	public void i_perform_get_operation_for(String path,String status) {
		
		RestAssuredExtension restAssuredExtension=new RestAssuredExtension();
		Map<String,String>pathParams=new HashMap<>();
		pathParams.put("pathParamKey1", path);
		Map<String,String>queryParams=new HashMap<>();
		queryParams.put("status", status);
		
		String urlWithPathParams=restAssuredExtension.getURIWithPathParameters("", pathParams);
		restAssuredExtension.getURIWithQueryParameters(urlWithPathParams, queryParams);
		response=restAssuredExtension.getJsonResponseFromAPI(urlWithPathParams);

	}

	@Then("I validate the expected result")
	public void i_validate_the_expected_result() {
		System.out.println(response.getBody().prettyPrint());
		String jsonString=response.body().asString();
		Assert.assertTrue(response.getStatusCode()==200, "The status code for Get request is not 200");
		Assert.assertTrue(jsonString.contains("fish") && jsonString.contains("available"), "The fish is not exists or available");			
	}
	
	@Given("I perform POST operation {string} to add new pet to the store")
	public void i_perform_post_operation_to_add_new_pet_to_the_store(String postPathParam) {
	   
	}

	@Then("validate the new pet {string} added and is available")
	public void validate_the_new_pet_added_and_is_available(String petName) {
	    
	}
}