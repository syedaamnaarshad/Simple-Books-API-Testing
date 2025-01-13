package baseService;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.TokenUtil;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseService {

    private static Response response;


    //Sets ContentType
    public static void setContentType(ContentType Type) {
        given().contentType(Type);
    }

    //getRequest helper method
    public static Response getRequest(String basePath) {
        response = given()
                .when()
                .get(basePath);
        return response;
    }

    //getRequest helper method
    public static Response getRequestWithAuth(String basePath) {
        response = given()
                .header("Authorization", "Bearer " + TokenUtil.getInstance().getAccessToken())
                .when()
                .get(basePath);
        return response;
    }


    //getRequest with parameters helper method
    public static Response getRequestWithParams(String basePath, Map<String, Object> pathParams) {
        response = given()
                .pathParams(pathParams)
                .when()
                .get(basePath);
        return response;
    }

    //getRequest with parameters and auth helper method
    public static Response getRequestWithParamsAndAuth(String basePath, Map<String, Object> pathParams) {
        response = given()
                .header("Authorization", "Bearer " + TokenUtil.getInstance().getAccessToken())
                .pathParams(pathParams)
                .when()
                .get(basePath);
        return response;
    }

    //postRequest helper method
    public static Response postRequest(String basePath, String body) {
        response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenUtil.getInstance().getAccessToken())
                .body(body)
                .when()
                .post(basePath);
        return response;

    }

    //patch request helper method
    public static Response patchRequest(String basePath, String body, Map<String,Object> pathParam) {
        response = given()
                .contentType(ContentType.JSON)
                .pathParams(pathParam)
                .header("Authorization", "Bearer " + TokenUtil.getInstance().getAccessToken())
                .body(body)
                .when()
                .patch(basePath);
        return response;
    }

    //delete request helper method
    public static Response deleteRequest(String basePath, Map<String, Object> pathParam) {
        response = given()
                .contentType(ContentType.JSON)
                .pathParams(pathParam)
                .header("Authorization", "Bearer " + TokenUtil.getInstance().getAccessToken())
                .when()
                .delete(basePath);
        return response;
    }
}
