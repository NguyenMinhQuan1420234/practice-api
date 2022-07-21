package utils.api;

import io.restassured.response.Response;
import io.restassured.http.Headers;
import org.json.JSONObject;
import org.json.JSONArray;

import utils.APIConstant;

import java.util.HashMap;
import java.util.Map;

public class UserHelper extends RequestHelper {

    private String prefixUrl = APIConstant.BASE_URL;

    public Response createUser(String name, String email, String gender, String status) {
        String url = prefixUrl + APIConstant.END_POINTS;
        JSONObject body = new JSONObject();
        body.put("name", name);
        body.put("email", email);
        body.put("gender",gender);
        body.put("status",status);
        Map<String, String> map = new HashMap<>();
        map.put("Authorization", "Bearer " + APIConstant.PRIMARY_TOKEN);
        Response response = sendRequest(
                APIConstant.RequestType.POST,
                url,
                createHeaders(map),
                body.toString());
        return response;
    }

    public Response getAllUser() {
        String url = prefixUrl + APIConstant.END_POINTS;
        Map<String,String> map = new HashMap<>();
        map.put("Authorization", "Bearer " + APIConstant.PRIMARY_TOKEN);
        Headers headers = createHeaders(map);
        Response response = sendRequest(
                APIConstant.RequestType.GET,
                url,
                headers, "");
        return response;

}
