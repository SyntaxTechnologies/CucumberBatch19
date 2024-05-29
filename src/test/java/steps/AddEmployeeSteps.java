package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

public class AddEmployeeSteps extends CommonMethods {


    @When("user clicks on Add Employee option")
    public void user_clicks_on_add_employee_option() {
        WebElement addEmpOption = driver.findElement(By.id("menu_pim_addEmployee"));
        click(addEmpOption);
    }

    @When("user enters firstname and middlename and lastname")
    public void user_enters_firstname_and_middlename_and_lastname() {
        WebElement firstNameLoc = driver.findElement(By.id("firstName"));
        WebElement middleNameLoc = driver.findElement(By.id("middleName"));
        WebElement lastNameLoc = driver.findElement(By.id("lastName"));

        sendText("gibril", firstNameLoc);
        sendText("MS", middleNameLoc);
        sendText("Hassan", lastNameLoc);

    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        WebElement saveButton = driver.findElement(By.id("btnSave"));
        click(saveButton);
    }

    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("Employee Added");
    }

    @When("user enters {string} , {string} and {string}")
    public void user_enters_and
            (String firstName, String middleName, String lastName) {
        WebElement firstNameLoc = driver.findElement(By.id("firstName"));
        WebElement middleNameLoc = driver.findElement(By.id("middleName"));
        WebElement lastNameLoc = driver.findElement(By.id("lastName"));

        sendText(firstName, firstNameLoc);
        sendText(middleName, middleNameLoc);
        sendText(lastName, lastNameLoc);
    }

    @When("user enters {string} and {string} and {string}.")
    public void user_enters_and_and(String fn, String mn, String ln) {
        WebElement firstNameLoc = driver.findElement(By.id("firstName"));
        WebElement middleNameLoc = driver.findElement(By.id("middleName"));
        WebElement lastNameLoc = driver.findElement(By.id("lastName"));

        sendText(fn, firstNameLoc);
        sendText(mn, middleNameLoc);
        sendText(ln, lastNameLoc);

    }
}
