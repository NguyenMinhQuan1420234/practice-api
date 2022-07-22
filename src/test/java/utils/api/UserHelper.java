package utils.api;

import io.restassured.response.Response;
import io.restassured.http.Headers;

import org.json.simple.JSONObject;
import utils.APIConstant;

import java.util.HashMap;
import java.util.Map;

public class UserHelper extends RequestHelper {

    private String prefixUrl = APIConstant.BASE_URL;

    public Response createUser(String name, String email, String gender, String status) {
        String url = prefixUrl + APIConstant.END_POINTS;
        JSONObject body = new JSONObject();
        System.out.println(name);
        System.out.println(email);
        System.out.println(gender);
        System.out.println(status);

        body.put("name", name);
        body.put("email", email);
        body.put("gender", gender);
        body.put("status", status);
        Map<String, String> map = new HashMap<>();
        map.put("Authorization", "Bearer " + APIConstant.PRIMARY_TOKEN);
        Headers headers = createHeaders(map);
        System.out.println(headers);
        Response response = sendRequest(
                APIConstant.RequestType.POST,
                url,
                headers,
                body.toString());
        return response;
    }

    public Response getAllUser(String page) {
        String url = prefixUrl + APIConstant.END_POINTS;
        Map<String, String> map = new HashMap<>();
        map.put("Authorization", "Bearer " + APIConstant.PRIMARY_TOKEN);
        Response response = sendRequest(
                APIConstant.RequestType.GET,
                url + "?page=" + page,
                createHeaders(map), "");
        return response;
    }

    public Response getUser(String userId) {
        String url = prefixUrl + APIConstant.END_POINTS;
        Map<String, String> map = new HashMap<>();
        map.put("Authorization", "Bearer " + APIConstant.PRIMARY_TOKEN);
        Response response = sendRequest(
                APIConstant.RequestType.GET,
                url + "/" + userId,
                createHeaders(map), "");
        return  response;
    }

    public Response updateUserDetails(String userId, String name, String email, String gender, String status) {
        String url = prefixUrl + APIConstant.END_POINTS;
        Map<String, String> map = new HashMap<>();
        map.put("Authorization", "Bearer " + APIConstant.PRIMARY_TOKEN);
        JSONObject body = new JSONObject();
        body.put("id", userId);
        if (name != null) {
            body.put("name", name);
        }
        if (gender != null) {
            body.put("gender", gender);
        }
        if (email != null) {
            body.put("email", email);
        }
        if (status != null) {
            body.put("status", status);
        }
        Response response = sendRequest(
                APIConstant.RequestType.PUT,
                url + "/" + userId,
                createHeaders(map),
                body.toString());
        return response;
    }

    public Response deleteUser(String userId) {
        String url = prefixUrl + APIConstant.END_POINTS;
        Map<String, String> map = new HashMap<>();
        map.put("Authorization", "Bearer " + APIConstant.PRIMARY_TOKEN);
        JSONObject body = new JSONObject();
        body.put("id", userId);
        Response response = sendRequest(
                APIConstant.RequestType.DELETE,
                url + "/" + userId,
                createHeaders(map),
                body.toString());
        return response;
    }

}
