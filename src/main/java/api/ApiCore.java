package api;

import java.io.FileReader;
import java.io.IOException;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*; 
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Reporter;

public class ApiCore {
	
	public Response GetRequest (String URL) {
		Response response = 
				  given()
				  .when()
				  .get(URL); 
		this.reporter(response); 
		return response; 
	}	
	
	public Response PostRequest (String filePath, String URL) throws IOException, ParseException { 
		
		JSONParser json = new JSONParser();
		FileReader reader = new FileReader(filePath); 
		Object obj = json.parse(reader); 
		  
		org.json.simple.JSONObject requestParams = (org.json.simple.JSONObject) obj;
		  
		RestAssured.baseURI = "https://reqres.in/api"; 
		RequestSpecification httpRequest = RestAssured.given()
				.headers("Content-Type", "application/json")
				.body(requestParams.toString());
		  
		Response response = httpRequest.post(URL);
		
		this.reporter(response, requestParams.toString());
		
		return response;	
		
	}	
	
	public Response PutRequest (String filePath, String URL) throws IOException, ParseException {
		JSONParser json = new JSONParser();
		FileReader reader = new FileReader(filePath); 
		Object obj = json.parse(reader); 
		  
		org.json.simple.JSONObject requestParams = (org.json.simple.JSONObject) obj;
		  
		RestAssured.baseURI = "https://reqres.in/api"; 
		RequestSpecification httpRequest = RestAssured.given()
				.headers("Content-Type", "application/json")
				.body(requestParams.toString());
		  
		Response response = httpRequest.put(URL);
		
		this.reporter(response, requestParams.toString());		
	  
		return response;	
	}
	
	public void reporter(Response response, String jsonBody) {
		
		Reporter.log("Json body: " + jsonBody);
		String responseBody = response.getBody().asString();
		int responseStatusCode = response.getStatusCode();
		Reporter.log("Response body: " + responseBody);
		Reporter.log("Response code: " + String.valueOf(responseStatusCode));	
		
	}
	
	public void reporter (Response response) {
		String responseBody = response.getBody().asString();
		int responseStatusCode = response.getStatusCode();
		Reporter.log("Response body: " + responseBody);
		Reporter.log("Response code: " + String.valueOf(responseStatusCode));	
	}

}
