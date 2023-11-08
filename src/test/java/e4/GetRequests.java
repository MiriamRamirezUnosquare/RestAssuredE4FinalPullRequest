package e4;

import api.ApiCore;

import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.Assert;

public class GetRequests {
	
	ApiCore apiCore;
	
  @Test(priority = 1)
  public void GetRequestListUsers() {
	  
	  Response test = apiCore.GetRequest("https://reqres.in/api/users?page=2"); 	  
	  Assert.assertEquals(200, test.statusCode()); 
	  
  }
  
  @Test(priority = 2)
  public void GetRequestSingleUser() {
	  
	  Response test = apiCore.GetRequest("https://reqres.in/api/users/2"); 	  
	  Assert.assertEquals(200, test.statusCode());	  
	  
  }
  
  @Test(priority = 3)
  public void GetRequestListResource() {
	  
	  Response test = apiCore.GetRequest("https://reqres.in/api/unknown"); 	  
	  Assert.assertEquals(200, test.statusCode());	  
	  
  }
  
  @Test(priority = 4)
  public void GetRequestListSingleResource() {
	  
	  Response test = apiCore.GetRequest("https://reqres.in/api/unknown/2"); 	  
	  Assert.assertEquals(200, test.statusCode());
	  
  }
  
  @BeforeSuite
  public void beforeSuite() {
	  
	  apiCore = new ApiCore();
	  
  }

}
