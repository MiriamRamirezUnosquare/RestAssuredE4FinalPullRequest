package e4;

import api.ApiCore;

import io.restassured.response.Response;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import org.testng.Assert;

public class PostRequests {
	
	ApiCore apiCore;
  
	@Test(priority = 1)
	public void PostRequestCreate() throws IOException, ParseException {
		
		Response test = apiCore.PostRequest(".\\Json\\PostCreate.json","/users"); 
		Assert.assertEquals(201, test.statusCode());
		
	}
	
	@Test(priority = 2)
	public void PostRequestLogin() throws IOException, ParseException{
		
		Response test = apiCore.PostRequest(".\\Json\\PostLogin.json","/login"); 
		Assert.assertEquals(200, test.statusCode()); 
	
	} 	
	
	@Test(priority = 3)
	public void PostRequestRegister() throws IOException, ParseException {
		
		Response test = apiCore.PostRequest(".\\Json\\PostRegister.json","/register"); 
		Assert.assertEquals(200, test.statusCode());
		
	} 
	
	@Test(priority = 4)
	public void PostRequestRegisterUnsuccesful() throws IOException, ParseException {
		
		Response test = apiCore.PostRequest(".\\Json\\PostRegisterUnsuccessful.json","/register"); 
		Assert.assertEquals(400, test.statusCode()); 
		
	}
  
	@BeforeSuite
	public void beforeSuite() {
		
		apiCore = new ApiCore(); 
	
	}

}
