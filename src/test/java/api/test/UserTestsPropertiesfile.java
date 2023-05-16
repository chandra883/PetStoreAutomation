package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UsersEndPointsPropertiesfile;
import api.payload.User;
import io.restassured.response.Response;

public class UserTestsPropertiesfile {
	
	Faker faker;
	User userPayload;
	
	public Logger logger;
	
	@BeforeClass
	public void setUpData() {
		
		faker = new Faker();
		userPayload = new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		//logs
		logger = LogManager.getLogger(this.getClass()); 
	}

	@Test(priority = 1)
	public void testPostUser(){
		
		logger.info("**************CREATE USER*********************");
		
		Response response = UsersEndPointsPropertiesfile.createUser(userPayload);
		response.then().log().body();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("**************USER IS CREATED*********************");
	}
	
	@Test(priority = 2)
	public void testGetUserByName() {
		
		logger.info("**************GET USER BY NAME*********************");
		
		Response response = UsersEndPointsPropertiesfile.readUser(this.userPayload.getUsername());
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("**************USER FECTHED BY NAME*********************");
	}
	
	
	@Test(priority = 3)
	public void testUpdateUserByName() {
		
		logger.info("**************UPDATE USER*********************");
		//update data using payload
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		
		Response response = UsersEndPointsPropertiesfile.updateUser(this.userPayload.getUsername(), userPayload);
		response.then().log().body();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//checking data after update
		Response responseAfterUpdate = UsersEndPointsPropertiesfile.readUser(this.userPayload.getUsername());
		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
	
		logger.info("**************USER DETAILS UPDATED*********************");
		
	}
	
	
	@Test(priority = 4)
	public void testDeleteByName() {
		
		logger.info("**************DELETE USER*********************");
	
		Response response = UsersEndPointsPropertiesfile.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
	
		logger.info("**************USER DELETED SUCCESSFULLY*********************");
	}
	
}


