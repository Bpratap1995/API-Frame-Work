package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	public static RequestSpecification reqspecbuilder;
	public RequestSpecification requestSpecification() throws IOException {
		
		if(reqspecbuilder==null) {
		PrintStream log = new PrintStream(new FileOutputStream("loging.txt"));

		 reqspecbuilder = new RequestSpecBuilder().setContentType(ContentType.JSON)
				.setBaseUri(getGlobalValue("baseUrl")).addFilter(ResponseLoggingFilter.logResponseTo(log))
				.addFilter(RequestLoggingFilter.logRequestTo(log)).build();
		return reqspecbuilder;
	}
		return reqspecbuilder;
	}

	public static String getGlobalValue(String key) throws IOException {
		Properties Prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Bhanu Pratap\\eclipse-workspace\\APIFramework\\src\\test\\java\\resources\\global.properties");
		Prop.load(fis);
		System.out.println(Prop.getProperty(key));
		return Prop.getProperty(key);

	}
	public String getJsonPath(Response response,String key) {
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		return js.get(key).toString();
	}

}
