package trainee.restassured.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import trainee.restassured.actions.HeaderValidationclass;

public class HeaderAuthorization {

	HeaderValidationclass hvc = new HeaderValidationclass();

	@Test
	public void givenUrlBody() {
		try {
			Assert.assertTrue(hvc.givenUrlBodyParam("qa", "publish_6847"));
		} catch (Exception ex) {
			System.out.println(ex.getMessage().toString());
		}
	}

}
