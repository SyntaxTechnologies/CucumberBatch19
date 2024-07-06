package APISteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class APIStepsClass {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    RequestSpecification request;
    Response response;
    public static String token;


    @Given("a JWT bearer token is generated")
    public void a_jwt_bearer_token_is_generated() {
        request = given().
                header("Content-Type","application/json").
                body("{\n" +
                        "  \"email\": \"testbatch19@test123.com\",\n" +
                        "  \"password\": \"test@123\"\n" +
                        "}");

        response = request.when().post("/generateToken.php");

        response.then().assertThat().statusCode(200);
        //store the value of token here
       token = "Bearer "+response.jsonPath().getString("token");
    }

    @Given("a request is prepared for creating an employee")
    public void a_request_is_prepared_for_creating_an_employee() {

        request = given().
                header("Content-Type","application/json").
                header("Authorization", token).
                body("{\n" +
                        "  \"emp_firstname\": \"manal\",\n" +
                        "  \"emp_lastname\": \"premium\",\n" +
                        "  \"emp_middle_name\": \"ms\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"1976-06-16\",\n" +
                        "  \"emp_status\": \"permanent\",\n" +
                        "  \"emp_job_title\": \"QA Manager\"\n" +
                        "}");

    }

    @When("a POST call is made to create the employee")
    public void a_post_call_is_made_to_create_the_employee() {
         response = request.when().post("/createEmployee.php");
        // System.out.println(response);
        response.prettyPrint();
    }

    @Then("the status code will be {int} for this call")
    public void the_status_code_will_be_for_this_call(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }

}
