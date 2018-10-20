package trainee.restassured.basepage;

import static io.restassured.RestAssured.baseURI;

public class BasePage {

	public BasePage(String url) {
//		super();

		baseURI = url;
	}
}
