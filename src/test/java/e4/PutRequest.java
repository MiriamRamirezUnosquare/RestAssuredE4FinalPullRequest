package e4;

import api.ApiCore;

import io.restassured.response.Response;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class PutRequest {
	
	ApiCore apiCore;
	
  @Test
  public void Put() throws IOException, ParseException {
	  
	  Response test = apiCore.Put(".\\Json\\Put.json","/users/2"); 
	  Assert.assertEquals(200, test.statusCode()); 
	  
  }

  @BeforeSuite
  public void beforeSuite() {
	  
	  apiCore = new ApiCore();
	  
  }

}
