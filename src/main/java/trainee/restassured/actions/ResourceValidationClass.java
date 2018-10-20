package trainee.restassured.actions;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

import org.slf4j.Logger;
import org.slf4j.impl.Log4jLoggerFactory;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import trainee.restassured.basepage.BasePage;

public class ResourceValidationClass extends BasePage{
static final Logger LOGGER = new Log4jLoggerFactory().getLogger(ResourceValidationClass.class.getName());
	
	public ResourceValidationClass() {
		super("https://jsonplaceholder.typicode.com");
	}
	
	/*TC1
	 * Implement Code Response validation. Verify that a code 200 is the one that returns. for all resources
	 * Get response and send it to console along with the name of the Test
	 * 
	 * */
	
	public boolean validationResource(String resource)
	{
		try {
		 RequestSpecification request = given().when();

		 Response response = request.get("/" + resource);
		 int status = response.getStatusCode();
		 LOGGER.info(resource + " TEST the status code is: " + status);
		 System.out.println(resource + " TEST the status code is: " + status);
		 
		 response.then().assertThat().statusCode(SC_OK);
		 return true;
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage().toString());
			return false;
		}

	}
}
