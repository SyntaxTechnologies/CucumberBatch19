package steps;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.math3.analysis.function.Add;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AddEmployeePage;
import utils.CommonMethods;

public class AddEmployeeSteps extends CommonMethods {


    @When("user clicks on Add Employee option")
    public void user_clicks_on_add_employee_option() {
        WebElement addEmpOption = driver.findElement(By.id("menu_pim_addEmployee"));
        click(addEmpOption);
    }

    @When("user enters firstname and middlename and lastname")
    public void user_enters_firstname_and_middlename_and_lastname() {
      //  WebElement firstNameLoc = driver.findElement(By.id("firstName"));
       // WebElement middleNameLoc = driver.findElement(By.id("middleName"));
       // WebElement lastNameLoc = driver.findElement(By.id("lastName"));

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
}
