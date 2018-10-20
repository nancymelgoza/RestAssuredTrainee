package trainee.restassured.actions;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.equalTo;

import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import trainee.restassured.basepage.BasePage;

public class SchemaValidationClass extends BasePage {
public SchemaValidationClass() {
		
		super("https://jsonplaceholder.typicode.com");
		
	}

	/*PART 2
	 * TC1
	 * Obtain the JsonSchema from the response and validate it for each of the 6 resources
	 * */

	public boolean schemaValidation(String resource, String schema) {
		try {
		
		String pathResource = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "\\resources\\" + schema)));
	
		given().when().get(resource).then().assertThat()
				.body(matchesJsonSchema(pathResource));
		
		return true;
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage().toString());
			return false;
		}
	}
	
	/*PART 2
	 * TC2
	 * Get id 20, 50 and 100 from the resource of the post and validate that the data of all nodes against 
	 * their original value. 
	 * */
	
	public boolean validateNodes(String id, String nameTest, Integer userId, String title, String msg) {
		try
		{

		RequestSpecification request = given().pathParam("id", id);
		Response response = request.when().get("/posts/{id}");
		System.out.println(nameTest + " TEST ");

		response.then().log().body().assertThat().body("userId", equalTo(userId)).and().body("id",equalTo(Integer.parseInt(id))).and().body("title", equalTo(title)).and().body("body", equalTo(msg));	
		return true;
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage().toString());
			return false;
		}

	}
	
	/*PART 2
	 * TC3
	 * Implement the requests of the examples:
	 * /comments?postId=1
	 * /posts?userId=1
	 * Use the function @param with Rest Assured
	 * */
	
	public boolean getJsonVal(String resource, String name, String val) {
		try
		{
		String json = given().pathParam("resource", resource).pathParam("name", name).pathParam("val", val).when().get("/{resource}?{name}={val}").body().asString();	

		System.out.println("the " + resource + " body is: " +json);
		return true;
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage().toString());
			return false;
		}
		
	}
}
