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

    @Test
    public void createUserSuccessfully() {
        Response response = userHelper.createUser("quan", "emailmotlandung@yahoo.com", "Male", "Active");
        response.then()
                .assertThat()
                .statusCode(200)
                .body("code", equalTo(201))
                .body("data.name", equalTo("quan"))
                .body("data.gender", equalTo("Male".toLowerCase()))
                .body("data.mail", equalTo("emailmotlandung@yahoo.com"))
                .body("data.status", equalTo("Active".toLowerCase()));
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
        Response response = userHelper.getUser(APIConstant.USER_ID);
        String ID = "";
        response.then()
                .assertThat()
                .statusCode(200)
                .body("code", equalTo(200))
                .body("data.id", equalTo(APIConstant.USER_ID));
    }

    @Test
    public void updateUsersSuccessfully() {
        Response response = userHelper.updateUserDetails(APIConstant.USER_ID,"Cao Ba Quat","tambaytamba@gmail.com","Female","Inactive");
        response.then()
                .assertThat()
                .statusCode(200)
                .body("code", equalTo(200))
                .body("data.id", equalTo(parseInt(APIConstant.USER_ID)))
                .body("data.name", equalTo("Cao Ba Quat"))
                .body("data.gender", equalTo("Female".toLowerCase()))
                .body("data.email", equalTo("tambaytamba@gmail.com"))
                .body("data.status", equalTo("Inactive".toLowerCase()));
        assertThat("Verify status code: ", response.statusCode(), equalTo(200));
    }

    @Test
    public void verifyUpdateUserBySchema() {
        Response respone = userHelper.updateUserDetails(APIConstant.USER_ID,"Cao Ba Quat","tambaytamba@gmail.com","Female","Inactive");
        userHelper.verifySchema(respone, "scheme.json");
    }
    @Test
    public void deleteUsersSuccessfully() {
        Response response = userHelper.deleteUser(APIConstant.USER_ID);
        response.then()
                .assertThat()
                .statusCode(200)
                .body("code", equalTo(204))
                .body("data", equalTo(null));
    }

}
