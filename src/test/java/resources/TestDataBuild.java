package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {
	public AddPlace addPlacePayLoad(String name,String language,String Address) {
		   AddPlace  p = new AddPlace();
		   p.setAccuracy(50);
		   p.setAddress(Address);
		   p.setLanuage(language);
		  
		   p.setName(name);
		   p.setPhone_numbe("8319366872");
		   
		   p.setWebsite("https://rahulshettyacademy.com");
		   List<String>myList = new ArrayList<String>();
		   myList.add("shoe Park");
		   myList.add("shop");
		   p.setTypes(myList);
		   Location l = new Location();
		   l.setLat("-38.383494");
		   l.setLng("33.427362");
		   p.setLocation(l);
		   return p;
	}
	public  String deletePlacePayLoad(String placeId) {
		return "{\r\n  \"place_id\": \""+placeId+"\"\r\n}";
	}

}
