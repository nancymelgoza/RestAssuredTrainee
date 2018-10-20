package trainee.restassured.tests;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import trainee.restassured.actions.ResourceValidationClass;

public class ResourceValidationTest {
	ResourceValidationClass rv = new ResourceValidationClass();

	@DataProvider(name = "resources")
	public Object[][] statusValidation() {
		return new Object[][] { 
				{ "posts" },
				{"comments"},		
				{ "albums" },
				{"photos"},
				{ "users" },
				{"todos"}	};
	}

	@Test(dataProvider = "resources")

	public void getvalResources(String resource) {
		try {
		 Assert.assertTrue(rv.validationResource(resource));
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage().toString());
		}
	}
}
