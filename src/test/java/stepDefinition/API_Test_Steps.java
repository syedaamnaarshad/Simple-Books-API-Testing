package stepDefinition;

import baseService.BaseService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import utils.OrderIdUtil;
import utils.TokenUtil;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class API_Test_Steps {

    private Response response;
    private final String statusPath = "/status";
    private final String apiAuthPath = "/api-clients/";
    private final String booksListPath = "/books"; //single book path: books/<id>
    private final String bookOrdersPath = "/orders";//single order path: orders/<id>
    public String accessToken;
    @Given("the valid endpoint to test")
    public void theValidEndpointToTest() {

        System.out.println("Base URI: " + RestAssured.baseURI);
    }

    @Then("^the response code received is (.*) and body status is (.*)$")
    public void verifyStatusPathCodeAndBodyReceived(int statusCode, String status) {
        //verifying the status code
        response.then().assertThat().statusCode(statusCode);
        //verifying the status body
        response.then().assertThat().body("status", equalTo(status));

    }

    @When("the get request is sent to the server with status path")
    public void getStatus() {
        //calling get request method to get API book status
        response = BaseService.getRequest(statusPath);
    }

    @When("the post request is sent to the server with the authentication path")
    public void theRequestIsSentToTheServerWithTheAuthenticationPath() {
        //generating a random number for different email id each time
        double x = Math.random() * 100;

        //storing json request body in a string for generating token
        String body = "{\n" + "   \"clientName\": \"APItester\",\n" + "   \"clientEmail\": \"apiTester" + x + "@example.com\"\n" + "}";

        //post request to generate token
        response = given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(apiAuthPath);

        System.out.println(response.getBody().asString());

        //extracting the access token and setting it
        accessToken = response.jsonPath().getString("accessToken");
        System.out.println("Response Token: " + accessToken);

        TokenUtil.getInstance().setAccessToken(accessToken);
        System.out.println("Authorization Header: Bearer " + TokenUtil.getInstance().getAccessToken());

    }

    @When("the get request is sent to the server with the get list of books path")
    public void theGetRequestIsSentToTheServerWithTheGetListOfBooksPath() {
        //get list of books
        response = BaseService.getRequest(booksListPath);

        System.out.println(response.getBody().asString());
    }

    @Then("the response code received is {int} and body contains the accessToken")
    public void theResponseCodeReceivedIsAndBodyContainsTheAccessToken(int statusCode) {
        //verifying the status code
        response.then().assertThat().statusCode(statusCode);

        Assert.assertTrue(response.getBody().asString().contains("accessToken"));

    }

    @When("the get request is sent to the server with the get a single book path")
    public void theGetRequestIsSentToTheServerWithTheGetASingleBookPath() {
        //single book base path
        String singleBookPath = booksListPath + "/{bookId}";

        //defining book id as 1
        Map<String, Object> pathParams = new HashMap<>();
        pathParams.put("bookId", 1);

        //get request for a single book
        response = BaseService.getRequestWithParams(singleBookPath, pathParams);

        System.out.println(response.getBody().asString());
    }


    @When("the post request is sent to the server with the order book path")
    public void thePostRequestIsSentToTheServerWithTheOrderBookPath() {
        //json request body stored in string to submit an order
        String body = "{\n" + "  \"bookId\": 1,\n" + "  \"customerName\": \"John\"\n" + "}";
        System.out.println("Authorization Header: Bearer " + TokenUtil.getInstance().getAccessToken());

        //submit an order of book
        response = BaseService.postRequest(bookOrdersPath, body);
        System.out.println(response.getBody().asString());


        //extract order id from response body and setting it
        String orderId = response.then().extract().path("orderId").toString();
        OrderIdUtil.getInstance().setOrderId(orderId);

        System.out.println("order ID: " + orderId);
    }


    @When("the get request is sent to the server with the get orders path")
    public void theGetRequestIsSentToTheServerWithTheGetOrdersPath() {
        //get all orders submitted
        response = BaseService.getRequestWithAuth(bookOrdersPath);

        System.out.println(response.getBody().asString());
    }


    @When("the get request is sent to the server with the get single order path")
    public void theGetRequestIsSentToTheServerWithTheGetSingleOrderPath() {
        //single order path
        String singleOrderPath = bookOrdersPath + "/{orderId}";

        //getting order id
        String orderId = OrderIdUtil.getInstance().getOrderId();

        //defining order id in path param by API chaining
        Map<String, Object> pathParams = new HashMap<>();
        pathParams.put("orderId", orderId);
        System.out.println("orderID:"+orderId);

        //get request to get single orderID
        response = BaseService.getRequestWithParamsAndAuth(singleOrderPath,pathParams );

        System.out.println(response.getBody().asString());
    }

    @When("the patch request is sent to the server with the patch get single order path")
    public void thePatchRequestIsSentToTheServerWithThePatchGetSingleOrderPath() {
        //updated name
        String updatedBody="{\"customerName\": \"Osama\"}";

        //single order path
        String singleOrderPath = bookOrdersPath + "/{orderId}";

        //getting order id
        String orderId = OrderIdUtil.getInstance().getOrderId();

        //defining order id in path param by API chaining
        Map<String, Object> pathParams = new HashMap<>();
        pathParams.put("orderId", orderId);
        System.out.println("orderID:"+orderId);

        //update the book order submitted
        response=BaseService.patchRequest(singleOrderPath,updatedBody,pathParams);

        System.out.println(response.getBody().asString());
    }


    @When("the delete request is sent to the server with the delete get single order path")
    public void theDeleteRequestIsSentToTheServerWithTheDeleteGetSingleOrderPath() {
        //single order path
        String singleOrderPath = bookOrdersPath + "/{orderId}";

        //getting order id
        String orderId = OrderIdUtil.getInstance().getOrderId();

        //defining order id in path param by API chaining
        Map<String, Object> pathParams = new HashMap<>();
        pathParams.put("orderId", orderId);
        System.out.println("orderID:"+orderId);

        //delete this order
        response= BaseService.deleteRequest(singleOrderPath,pathParams);

        System.out.println(response.getBody().asString());
    }

    @Then("the response code received is {int}")
    public void theResponseCodeReceivedIs(int statusCode) {
        //verify status code
        response.then().assertThat().statusCode(statusCode);
    }
}
