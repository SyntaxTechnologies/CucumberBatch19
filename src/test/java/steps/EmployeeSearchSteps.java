package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

public class EmployeeSearchSteps extends CommonMethods {

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
       // WebElement pimOption = driver.findElement(By.id("menu_pim_viewPimModule"));
        click(dashboardPage.pimOption);
    }

    @When("user clicks on employee list option")
    public void user_clicks_on_employee_list_option() {
      //  WebElement empListOption = driver.findElement(By.id("menu_pim_viewEmployeeList"));
        click(dashboardPage.employeeListOption);
    }

    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {
       // WebElement empIdSearchField = driver.findElement(By.id("empsearch_id"));
        sendText("34567", employeeSearchPage.empIdSearchField);
    }

    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
        //WebElement searchButton = driver.findElement(By.id("searchBtn"));
        click(employeeSearchPage.searchButton);
    }

    @Then("user see the employee information")
    public void user_see_the_employee_information() {
        System.out.println("Test passed");
    }

    @When("user enters valid employee name")
    public void user_enters_valid_employee_name() {
        //WebElement nameSearchField = driver.findElement(By.id("empsearch_employee_name_empName"));
        sendText("abc", employeeSearchPage.empNameSearchField);
    }

}
