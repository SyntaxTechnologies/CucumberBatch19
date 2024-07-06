package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardcodedExamples {

    //the intention is to learn how API's work
    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3MjAyNzgwMzQsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTcyMDMyMTIzNCwidXNlcklkIjoiNjYyMSJ9.7JxIa4h9rqEs2C3xnRPn4F4uPTgzp42T82Kb1IWLYrE";
    static String employee_id;

    @Test
    //in order to create the employee
    //first prepare the request, then hit the endpoint, validate the response
    public void acreateEmployee(){
        //preparing the request
        RequestSpecification preparedRequest = given().
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
        //hitting the endpoint, sending the request
        Response response = preparedRequest.when().post("/createEmployee.php");

       // System.out.println(response);
        response.prettyPrint();
       //json - keys, it returns the value
        employee_id =  response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);
        //validate status code
        response.then().assertThat().statusCode(201);
        //validate header //Connection: Keep-Alive
        response.then().assertThat().header("Connection","Keep-Alive");
        //validate body
        response.then().assertThat().
                body("Employee.emp_firstname",equalTo("manal"));
        response.then().assertThat().
                body("Employee.emp_middle_name",equalTo("ms"));
        response.then().assertThat().
                body("Employee.emp_lastname",equalTo("premium"));

    }

    @Test
    //getting one employee
    public void bgetOneEmployee(){
        //prepare the request
        RequestSpecification request = given().
                header("Content-Type","application/json").
                header("Authorization", token).
                queryParam("employee_id", employee_id);

        //hitting the endpoint
        Response response = request.when().get("/getOneEmployee.php");
        response.prettyPrint();

        //validate the status code
        response.then().assertThat().statusCode(200);
        //get the employee id from  body
        String empId = response.jsonPath().getString("employee.employee_id");
        Assert.assertEquals(empId, employee_id);
        response.then().assertThat().
                body("employee.emp_firstname",equalTo("manal"));
        response.then().assertThat().
                body("employee.emp_middle_name",equalTo("ms"));
        response.then().assertThat().
                body("employee.emp_lastname",equalTo("premium"));

    }

    @Test
    public void cupdateEmployee(){
        //prepare the request
        RequestSpecification request = given().
                header("Content-Type","application/json").
                header("Authorization", token).
                body("{\n" +
                        "  \"employee_id\": \""+employee_id+"\",\n" +
                        "  \"emp_firstname\": \"Dmytro\",\n" +
                        "  \"emp_lastname\": \"pedrick\",\n" +
                        "  \"emp_middle_name\": \"sm\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2001-06-29\",\n" +
                        "  \"emp_status\": \"temporary\",\n" +
                        "  \"emp_job_title\": \"admin\"\n" +
                        "}");
        //sending the request
        Response response = request.when().put("/updateEmployee.php");
        //validate the response
        response.then().assertThat().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void dgetUpdatedEmployee(){
        RequestSpecification request = given().
                header("Content-Type","application/json").
                header("Authorization", token).
                queryParam("employee_id", employee_id);

        //hitting the endpoint
        Response response = request.when().get("/getOneEmployee.php");
        response.prettyPrint();

        //validate the status code
        response.then().assertThat().statusCode(200);
    }



}
