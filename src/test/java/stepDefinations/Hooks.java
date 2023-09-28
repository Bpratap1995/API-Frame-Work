package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	@Before
	public void beforeScenario() throws IOException {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>");
		APIsteps m = new APIsteps();
		if(APIsteps.place_Id==null) {
		
		m.add_place_payload_with("Shetty", "English", "India");
		m.user_calls_with_http_request("AddPlaceApi", "POST");
		m.verify_place_id_created_maps_to_using("Shetty", "getPlaceAPI");
	}

	}
}
