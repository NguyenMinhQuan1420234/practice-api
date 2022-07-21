package tests;

import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import utils.APIConstant;
import utils.api.UserHelper;

import static org.hamcrest.MatcherAssert.assertThat;

public class UserTest {
    UserHelper userHelper = new UserHelper();

//    @Test
//    public void createUserSuccessfully() {
//        Response response = userHelper.createUser(NAME, GENDER, EMAIL, STATUS);
//        response.then()
//                .assertThat()
//                .statusCode(200)
//                .body("code", equalTo(201))
//                .body("data.name", equalTo(NAME))
//                .body("data.gender", equalTo(GENDER.toLowerCase()))
//                .body("data.email", equalTo(EMAIL))
//                .body("data.status", equalTo(STATUS.toLowerCase()));
//    }
//
//    @Test
//    public void getUsersSuccessfully() {
//        Response response = userHelper.getUser(null);
//        response.then()
//                .assertThat()
//                .statusCode(200)
//                .body("code", equalTo(200))
//                .body("meta.pagination.total", notNullValue())
//                .body("meta.pagination.page", notNullValue())
//                .body("meta.pagination.limit", notNullValue())
//                .body("data[0]", hasKey("id"))
//                .body("data[0]", hasKey("name"))
//                .body("data[0]", hasKey("email"))
//                .body("data[0]", hasKey("gender"))
//                .body("data[0]", hasKey("status"));
//    }
//
//    @Test
//    public void getUserDetailSuccessfully() {
//        Response response = userHelper.getUser(Integer.toString(USER_ID));
//        response.then()
//                .assertThat()
//                .statusCode(200)
//                .body("code", equalTo(200))
//                .body("data.id", equalTo(USER_ID));
//    }
//
//    @Test
//    public void updateUsersSuccessfully() {
//        Response response = userHelper.updateUser(USER_ID, UPDATE_NAME, UPDATE_GENDER, UPDATE_EMAIL, UPDATE_STATUS);
//        response.then()
//                .assertThat()
//                .statusCode(200)
//                .body("code", equalTo(200))
//                .body("data.id", equalTo(USER_ID))
//                .body("data.name", equalTo(UPDATE_NAME))
//                .body("data.gender", equalTo(UPDATE_GENDER.toLowerCase()))
//                .body("data.email", equalTo(UPDATE_EMAIL))
//                .body("data.status", equalTo(UPDATE_STATUS.toLowerCase()));
//        assertThat("Verify status code: ", response.statusCode(), equalTo(200));
//    }
//
//    @Test
//    public void deleteUsersSuccessfully() {
//        Response response = userHelper.deleteUser(USER_ID);
//        response.then()
//                .assertThat()
//                .statusCode(200)
//                .body("code", equalTo(204))
//                .body("data", equalTo(null));
//    }
//
//    @Test
//    public void verifyUpdateUserJsonSchema() {
//        Response response = userHelper.updateUser(UPDATE_USER_ID, null, UPDATE_GENDER, UPDATE_EMAIL, UPDATE_STATUS);
//        assertThat("Verify status code: ", response.statusCode(), equalTo(200));
//        userHelper.verifySchema(response, "schema.json");
//    }
}
