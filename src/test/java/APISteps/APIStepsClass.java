package APISteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import utils.APIConstants;
import utils.APIPayloadConstants;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class APIStepsClass {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    RequestSpecification request;
    Response response;
    public static String token;
    public static String employee_id;


    @Given("a JWT bearer token is generated")
    public void a_jwt_bearer_token_is_generated() {
        request = given().
                header(APIConstants.HEADER_CONTENT_TYPE_KEY,
                        APIConstants.HEADER_CONTENT_TYPE_VALUE).
                body("{\n" +
                        "  \"email\": \"testbatch19@test123.com\",\n" +
                        "  \"password\": \"test@123\"\n" +
                        "}");

        response = request.when().post(APIConstants.GENERATE_TOKEN_URI);

        response.then().assertThat().statusCode(200);
        //store the value of token here
       token = "Bearer "+response.jsonPath().getString("token");
    }

    @Given("a request is prepared for creating an employee")
    public void a_request_is_prepared_for_creating_an_employee() {

        request = given().
                header(APIConstants.HEADER_CONTENT_TYPE_KEY,
                        APIConstants.HEADER_CONTENT_TYPE_VALUE).
                header(APIConstants.HEADER_AUTHORIZATION_KEY, token).
                body(APIPayloadConstants.createEmployeePayload());

    }

    @When("a POST call is made to create the employee")
    public void a_post_call_is_made_to_create_the_employee() {
         response = request.when().post(APIConstants.CREATE_EMPLOYEE_URI);
        // System.out.println(response);
        response.prettyPrint();
    }

    @Then("the status code will be {int} for this call")
    public void the_status_code_will_be_for_this_call(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }

    @Then("the employee created contains key {string} and value {string}")
    public void the_employee_created_contains_key_and_value
            (String key, String value) {
        response.then().assertThat().body(key,equalTo(value));
    }

    @Then("the employee id {string} is stored as a global variable")
    public void the_employee_id_is_stored_as_a_global_variable(String empIdpath) {
        employee_id = response.jsonPath().getString(empIdpath);
        System.out.println(employee_id);
    }
//----------------------------------------------------------------------------------
@Given("a request is prepared for retrieving an employee")
public void a_request_is_prepared_for_retrieving_an_employee() {
    request = given().
            header(APIConstants.HEADER_CONTENT_TYPE_KEY,
                    APIConstants.HEADER_CONTENT_TYPE_VALUE).
            header(APIConstants.HEADER_AUTHORIZATION_KEY, token).queryParam("employee_id",employee_id);
}
    @When("a GET call is made to get the employee")
    public void a_get_call_is_made_to_get_the_employee() {
        response = request.when().get(APIConstants.GET_ONE_EMPLOYEE_URI);
        response.prettyPrint();
    }

    @Then("the status code for this will be {int}")
    public void the_status_code_for_this_will_be(Integer int1) {
        response.then().assertThat().statusCode(int1);
    }
    @Then("the employee id we got {string} must match with global id")
    public void the_employee_id_we_got_must_match_with_global_id(String empId) {
        String tempId = response.jsonPath().getString(empId);
        Assert.assertEquals(tempId, employee_id);
    }

    @Then("the received data from {string} object matches with the data we used to create employee")
    public void the_received_data_from_object_matches_with_the_data_we_used_to_create_employee
            (String empObject, io.cucumber.datatable.DataTable dataTable) {
        //data coming from feature file to validate with get call
        List<Map<String,String>> expectedData = dataTable.asMaps();
        //it will return the complete body from get call
        Map<String, String> actualData = response.body().jsonPath().get(empObject);

        //here I am expecting one map from multiple entries if any
        for (Map<String, String> map:expectedData
             ) {
            //here I am expecting all the unique keys
            Set<String> keys = map.keySet();
            //here I am returning one key at one point of time
            for(String key:keys){
                //it returns the value against the key
                String expectedValue = map.get(key);
                String actualDataValue = actualData.get(key);
                Assert.assertEquals(expectedValue, actualDataValue);
            }
        }

    }


    //------------------------------------------------------------------------------------------

    @Given("a request is prepared for creating an employee using json payload")
    public void a_request_is_prepared_for_creating_an_employee_using_json_payload() {
        request = given().
                header(APIConstants.HEADER_CONTENT_TYPE_KEY,
                        APIConstants.HEADER_CONTENT_TYPE_VALUE).
                header(APIConstants.HEADER_AUTHORIZATION_KEY, token).
                body(APIPayloadConstants.createEmployeePayloadJson());
    }

    @Given("a request is prepared for creating an employee using json payload dynamic {string} , {string} , {string} , {string} , {string} , {string} , {string}")
    public void a_request_is_prepared_for_creating_an_employee_using_json_payload_dynamic
            (String fn, String ln,
             String mn, String gender,
             String dob, String empstatus,
             String title) {
        request = given().
                header(APIConstants.HEADER_CONTENT_TYPE_KEY,
                        APIConstants.HEADER_CONTENT_TYPE_VALUE).
                header(APIConstants.HEADER_AUTHORIZATION_KEY, token).
                body(APIPayloadConstants.
                        createEmployeePayloadJsonDynamic(fn,ln,mn,gender,dob,
                                empstatus,title));
    }

}
