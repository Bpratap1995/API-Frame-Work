package stepDefinations;

import static org.junit.Assert.*;
import java.io.IOException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.*;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class APIsteps extends Utils {
	RequestSpecification req;
	ResponseSpecification resspec;
	Response response;
	TestDataBuild b = new TestDataBuild();
	static String place_Id;

	@Given("Add place payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {

		req = given().spec(requestSpecification()).body(b.addPlacePayLoad(name, language, address));

	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
		APIResources resouceApi = APIResources.valueOf(resource);
		String re = resouceApi.getResource();
		System.out.println(re);

		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		if (method.equalsIgnoreCase("POST")) {
			response = req.when().post(re);

		} else if (method.equalsIgnoreCase("GET")) {
			response = req.when().get(re);

		}

	}

	@Then("the api call got  success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {

		assertEquals(response.getStatusCode(), 200);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String Expected) {

		assertEquals(getJsonPath(response, keyValue), Expected);
	}

	@Then("Verify placeId created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String ExpectedName, String resource) throws IOException {

		 place_Id = getJsonPath(response, "place_id");

		req = given().spec(requestSpecification()).queryParam("place_id", place_Id);
		user_calls_with_http_request(resource, "GET");
		//System.out.println("....." + response.asString());
		// String actual = getJsonPath(response,"name");
		// assertEquals(actual,ExpectedName);

	}
	@Given("Delete PlacePayload")
	public void delete_place_payload() throws IOException {
		req = given().spec(requestSpecification()).body(b.deletePlacePayLoad(place_Id));
	  
	}


}
