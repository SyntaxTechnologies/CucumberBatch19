package steps;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.math3.analysis.function.Add;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AddEmployeePage;
import utils.CommonMethods;
import utils.ExcelReader;

import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {


    @When("user clicks on Add Employee option")
    public void user_clicks_on_add_employee_option() {
     //   WebElement addEmpOption = driver.findElement(By.id("menu_pim_addEmployee"));
        click(dashboardPage.addEmployeeOption);
    }

    @When("user enters firstname and middlename and lastname")
    public void user_enters_firstname_and_middlename_and_lastname() {
      //  WebElement firstNameLoc = driver.findElement(By.id("firstName"));
       // WebElement middleNameLoc = driver.findElement(By.id("middleName"));
       // WebElement lastNameLoc = driver.findElement(By.id("lastName"));
     //   System.out.println(1/0);
      //  AddEmployeePage addEmployeePage = new AddEmployeePage();
        sendText("gibril", addEmployeePage.firstNameLoc);
        sendText("MS", addEmployeePage.middleNameLoc);
        sendText("Hassan", addEmployeePage.lastNameLoc);

    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
       // AddEmployeePage addEmployeePage = new AddEmployeePage();
       // WebElement saveButton = driver.findElement(By.id("btnSave"));
        click(addEmployeePage.saveButton);
    }

    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("Employee Added");
    }

    @When("user enters {string} , {string} and {string}")
    public void user_enters_and
            (String firstName, String middleName, String lastName) {
       // WebElement firstNameLoc = driver.findElement(By.id("firstName"));
       // WebElement middleNameLoc = driver.findElement(By.id("middleName"));
      //  WebElement lastNameLoc = driver.findElement(By.id("lastName"));

      //  AddEmployeePage addEmployeePage = new AddEmployeePage();
        sendText(firstName, addEmployeePage.firstNameLoc);
        sendText(middleName, addEmployeePage.middleNameLoc);
        sendText(lastName, addEmployeePage.lastNameLoc);
    }

    @When("user enters {string} and {string} and {string}.")
    public void user_enters_and_and(String fn, String mn, String ln) {
     //   WebElement firstNameLoc = driver.findElement(By.id("firstName"));
     //   WebElement middleNameLoc = driver.findElement(By.id("middleName"));
     //   WebElement lastNameLoc = driver.findElement(By.id("lastName"));

      //  AddEmployeePage addEmployeePage = new AddEmployeePage();
        sendText(fn, addEmployeePage.firstNameLoc);
        sendText(mn, addEmployeePage.middleNameLoc);
        sendText(ln, addEmployeePage.lastNameLoc);

    }

    @When("user enters firstname and middlename and lastname from data table and verify it")
    public void user_enters_firstname_and_middlename_and_lastname_from_data_table_and_verify_it
            (io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> newEmployees = dataTable.asMaps();

        //to get one map at one time from multiple maps
        for (Map<String, String> employee:
             newEmployees) {
            //it will return my value from key
            String firstNameValue = employee.get("firstname");
            String middleNameValue = employee.get("middlename");
            String lastNameValue = employee.get("lastname");

            sendText(firstNameValue, addEmployeePage.firstNameLoc);
            sendText(middleNameValue, addEmployeePage.middleNameLoc);
            sendText(lastNameValue, addEmployeePage.lastNameLoc);

            click(addEmployeePage.saveButton);
            Thread.sleep(2000);
            //to add multiple employees, I have to click on add employee
            click(dashboardPage.addEmployeeOption);
            Thread.sleep(2000);
        }
    }

    @When("user adds multiple employees from excel and validate them")
    public void user_adds_multiple_employees_from_excel_and_validate_them() throws InterruptedException {
        List<Map<String, String>> employeeData =  ExcelReader.read();

        for (Map<String, String> employee:
                employeeData){

            sendText(employee.get("firstName"), addEmployeePage.firstNameLoc);
            sendText(employee.get("middleName"), addEmployeePage.middleNameLoc);
            sendText(employee.get("lastName"), addEmployeePage.lastNameLoc);
            sendText(employee.get("Photograph"), addEmployeePage.photograph);

            //i have to click on checkbox if it is not selected
            if(!addEmployeePage.checkBox.isSelected()){
                click(addEmployeePage.checkBox);
            }

            sendText(employee.get("Username"), addEmployeePage.username);
            sendText(employee.get("Password"), addEmployeePage.passwordUser);
            sendText(employee.get("confirmPassword"), addEmployeePage.confirmPasswordUser);
            click(addEmployeePage.saveButton);

            Thread.sleep(2000);
            //verification is pending
            //which is your homework

            click(dashboardPage.addEmployeeOption);
            Thread.sleep(2000);
        }

    }
}
