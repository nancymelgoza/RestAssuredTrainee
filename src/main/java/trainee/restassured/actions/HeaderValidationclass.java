package trainee.restassured.actions;

import static io.restassured.RestAssured.*;

import org.testng.Assert;

import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import trainee.restassured.basepage.BasePage;

public class HeaderValidationclass extends BasePage{

	public HeaderValidationclass() {
		super("https://gp_search.grey.com/gp_searchapi");
	}

	String aut;
	
	/*PART 3
	 * TC 1
	 * Execute the request: https://gp_search.grey.com/gp_searchapi/search?u=qa&q=publish_6847&d=id&p=t&c=t&s=publish&m=all
	 * Use @param for qa and publish..
	 * Implement the "Authorization" Header
	 * Get json
	 * */
	
	public boolean givenUrlBodyParam(String qa, String publish) { // String aut
		try {
			Header authorizationHeader = new Header("Authorization", aut);
			RequestSpecification httpRequest = given().pathParam("u", qa).pathParam("q", publish)
					.pathParam("d", "id").pathParam("p", "t").pathParam("c", "t").pathParam("s", "publish")
					.pathParam("m", "all");
			httpRequest.header(authorizationHeader);
	        Assert.assertNotNull(authorizationHeader);
			Response response = httpRequest.get("search?u={u}&q={q}&d={d}&p={p}&c={c}&s={s}&m={m}");

			System.out.println("Response Body is : " + response.body().asString());
			return true;

		} catch (Exception ex) {
			System.out.println(ex.getMessage().toString());
			return false;
		}

	}
	
	

}
