package tests;

import io.restassured.response.Response;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.APIConstant;
import utils.api.UserHelper;

import static java.lang.Integer.parseInt;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UserTest {
    UserHelper userHelper = new UserHelper();
    public static String newUserId;
    @Test
    public void createUserSuccessfully() {
        Response response = userHelper.createUser("quan", "emailbonlandung@yahoo.com", "Male", "Active");
        response.then()
                .assertThat()
                .statusCode(200)
                .body("code", equalTo(201))
                .body("data.name", equalTo("quan"))
                .body("data.gender", equalTo("Male".toLowerCase()))
                .body("data.email", equalTo("emailbonlandung@yahoo.com"))
                .body("data.status", equalTo("Active".toLowerCase()));
        newUserId = response.jsonPath().getString("data.id");
        System.out.println(newUserId);
    }

    @Test
    public void getUsersInSpecificPageSuccessfully() {
        Response response = userHelper.getAllUser("2");
        response.then()
                .assertThat()
                .statusCode(200)
                .body("code", equalTo(200))
                .body("meta.pagination.total", notNullValue())
                .body("meta.pagination.page", notNullValue())
                .body("meta.pagination.limit", notNullValue())
                .body("data[0]", hasKey("id"))
                .body("data[0]", hasKey("name"))
                .body("data[0]", hasKey("email"))
                .body("data[0]", hasKey("gender"))
                .body("data[0]", hasKey("status"));
    }

    @Test
    public void getUserDetailSuccessfully() {
        Response response = userHelper.getUser(newUserId);
        String ID = "";
        response.then()
                .assertThat()
                .statusCode(200)
                .body("code", equalTo(200))
                .body("data.id", equalTo(parseInt(newUserId)));
    }

    @Test
    public void updateUsersSuccessfully() {
        Response response = userHelper.updateUserDetails(newUserId,"Cao Ba Quat","tambaytamba@gmail.com","Female","Inactive");
        response.then()
                .assertThat()
                .statusCode(200)
                .body("code", equalTo(200))
                .body("data.id", equalTo(parseInt(newUserId)))
                .body("data.name", equalTo("Cao Ba Quat"))
                .body("data.gender", equalTo("Female".toLowerCase()))
                .body("data.email", equalTo("tambaytamba@gmail.com"))
                .body("data.status", equalTo("Inactive".toLowerCase()));
        assertThat("Verify status code: ", response.statusCode(), equalTo(200));
    }

    @Test
    public void verifyUpdateUserBySchema() {
        System.out.println(newUserId);
        Response respone = userHelper.updateUserDetails(newUserId,"Cao Ba Quat","tambaytamba@gmail.com","Female","Inactive");
        userHelper.verifySchema(respone, "scheme.json");
    }
    @Test(priority = 3)
    public void deleteUsersSuccessfully() {
        Response response = userHelper.deleteUser(newUserId);
        response.then()
                .assertThat()
                .statusCode(200)
                .body("code", equalTo(204))
                .body("data", equalTo(null));
    }

}
