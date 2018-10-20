package trainee.restassured.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import trainee.restassured.actions.SchemaValidationClass;


public class SchemaValidationTests {
	SchemaValidationClass svc = new SchemaValidationClass();

	@DataProvider(name = "schemas")
	public Object[][] statusValidation() {
		return new Object[][] { 
				{ "/posts", "postSchema.json" },
				{"/comments","commentsSchema.json" },		
				{ "/albums", "albumsSchema.json" },
				{"/photos", "photosSchema.json"},
				{"/users", "usersSchema.json" },
				{"/todos", "todosSchema.json"}	
				};
	}

	@Test(priority =1, testName = "postsSchemaValidation", dataProvider = "schemas")
	public void schemaValidation(String resource, String schema) {
		try {
			System.out.println(svc.schemaValidation(resource, schema));

			Assert.assertTrue(svc.schemaValidation(resource, schema));

		} catch (Exception ex) {
			System.out.println(ex.getMessage().toString());
		}

	}


	@Test(priority = 2, testName = "postsId20")
	public void postsId20() {
		try {
		String msg = "qui consequuntur ducimus possimus quisquam amet similique" + "\n" + "suscipit porro ipsam amet"
				+ "\n" + "eos veritatis officiis exercitationem vel fugit aut necessitatibus totam" + "\n"
				+ "omnis rerum consequatur expedita quidem cumque explicabo";
		boolean resul = svc.validateNodes("20", "postsId20", 2, "doloribus ad provident suscipit at", msg);
		Assert.assertTrue(resul);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage().toString());
		}

	}

	@Test(priority = 3, testName = "postsId50")
	public void postsId50() {
		try {
		String msg = "error suscipit maxime adipisci consequuntur recusandae" + "\n"
				+ "voluptas eligendi et est et voluptates" + "\n" + "quia distinctio ab amet quaerat molestiae et vitae"
				+ "\n" + "adipisci impedit sequi nesciunt quis consectetur";
		boolean resul = svc.validateNodes("50", "postsId50", 5,
				"repellendus qui recusandae incidunt voluptates tenetur qui omnis exercitationem", msg);
		Assert.assertTrue(resul);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage().toString());
		}
		
	}

	@Test(priority = 4, testName = "postsId100")
	public void postsId100() {
		try {
		String msg = "cupiditate quo est a modi nesciunt soluta" + "\n" + "ipsa voluptas error itaque dicta in" + "\n"
				+ "autem qui minus magnam et distinctio eum" + "\n" + "accusamus ratione error aut";
		boolean resul = svc.validateNodes("100", "postsId100", 10, "at nam consequatur ea labore ea harum", msg);
		Assert.assertTrue(resul);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage().toString());
		}
	}

	@Test(priority = 5)
	public void getCommentsPostId1() {
		try {
		Assert.assertTrue(svc.getJsonVal("comments", "postId", "1"));
		
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage().toString());
		}
	}

	@Test(priority = 6)
	public void getPostsUserId1() {
		try {
		Assert.assertTrue(svc.getJsonVal("posts", "userId", "1"));
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage().toString());
		}
	}
}
