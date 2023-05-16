package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UsersEndPoints;
import api.payload.User;
import api.utilities.DataProvider;
import io.restassured.response.Response;

public class DataDrivenTests {

	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProvider.class)
	public void testPostUser(String userId, String username, String firstname, String lastname, String userEmail,
			String password, String ph) {

		User userPayload = new User();
		userPayload.setId(Integer.parseInt(userId));
		userPayload.setUsername(username);
		userPayload.setFirstName(firstname);
		userPayload.setLastName(lastname);
		userPayload.setEmail(userEmail);
		userPayload.setPassword(password);
		userPayload.setPhone(ph);
		
		Response response = UsersEndPoints.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);

	}
	
	@Test(priority = 2, dataProvider = "UserNames" , dataProviderClass =DataProvider.class )
	public void testDeleteUserByName(String username) {
		
		Response response = UsersEndPoints.deleteUser(username);
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}

}
