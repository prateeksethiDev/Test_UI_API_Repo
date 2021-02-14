package reusableComponents;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class RestAssuredExtension {
	public static RequestSpecification  request;
	
	public RestAssuredExtension(){
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setBaseUri("https://petstore.swagger.io/v2/pet");
		builder.setContentType(ContentType.JSON);
		RequestSpecification  requestSpec=builder.build();
		request=RestAssured.given().spec(requestSpec);
	}
	
	public  String getURIWithPathParameters(String url,Map<String,String>pathParams) {
		int counter=0;
		StringBuffer sb = new StringBuffer();
		sb.append(url);
			Set<Entry<String, String>> entryPathParams=pathParams.entrySet();
			Iterator<Entry<String, String>> itr=entryPathParams.iterator();
			while(itr.hasNext()) {
				counter++;	
				Entry<String, String> entry=itr.next();
				String pathParamKey=entry.getKey();
				String pathParamValue=entry.getValue();
				if(request!=null) {
				request.given().pathParam(pathParamKey, pathParamValue);
				}
			}
			for(int index=1;index<=counter;index++) {
				if(index==1)
				sb.append("/{pathParamKey"+index+"}");
				else
					sb.append("{pathParamKey"+index+"}");
			}
			return sb.toString();
	}
	
	public  void getURIWithQueryParameters(String url,Map<String,String>queryParams) {

		Set<Entry<String, String>> entryPathParams=queryParams.entrySet();
		Iterator<Entry<String, String>> itr=entryPathParams.iterator();
		while(itr.hasNext()) {
			Entry<String, String> entry=itr.next();
			String queryParamKey=entry.getKey();
			String queryParamValue=entry.getValue();
			if(request!=null) {
			request.given().queryParam(queryParamKey, queryParamValue);		
			}
		}
	}
	
	

	public ResponseOptions<Response> getJsonResponseFromAPI(String url) {
		ResponseOptions<Response> response=request
		        .get(url);   
		return response;
	}
	
	public String generatePostRequestToAddPet(Map<String,String>postReqMap) {
		
		String petId=postReqMap.get("id");
		String petName=postReqMap.get("name");
		String petCategoryId=postReqMap.get("categoryId");
		String petCategoryName=postReqMap.get("categoryName");
		String petAvailabilityStatus=postReqMap.get("availablityStatus");
		
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		jsonArray.put(jsonObject);
		jsonObject.put("id", petId);
		JSONObject categoryJsonObject = new JSONObject();
		categoryJsonObject.put("id", petCategoryId);
		categoryJsonObject.put("name", petCategoryName);
		jsonObject.put("category", categoryJsonObject);
		jsonObject.put("name", petName);
		JSONArray photoUrlsJsonArr = new JSONArray();
		photoUrlsJsonArr.put("goofy_url");
		jsonObject.put("photoUrls", photoUrlsJsonArr);
		JSONArray tagsJsonArr = new JSONArray("tags");
		JSONObject jsonObjectTags = new JSONObject();
		jsonObjectTags.put("id", 101);
		jsonObjectTags.put("name", petName);
		tagsJsonArr.put(jsonObjectTags);
		jsonObject.put("status", petAvailabilityStatus);

		return jsonObject.toString();
	}
}
