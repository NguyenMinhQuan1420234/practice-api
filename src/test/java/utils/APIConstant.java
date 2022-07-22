package utils;

public class APIConstant {
    public enum RequestType {
        GET,
        POST,
        PUT,
        DELETE,
        PATCH
    }

    public static String BASE_URL = "https://gorest.co.in/public-api";
    public static String END_POINTS = "/users";
    public static String PRIMARY_TOKEN = "42acc767ecb3b4e37f33d491c9497d476363cf93946c4c804198b6b6ac38755c";
    public static String USER_ID = "4516";
    public static String NEW_USER_ID;
    public static String PAGE = "?page=%s";
}
