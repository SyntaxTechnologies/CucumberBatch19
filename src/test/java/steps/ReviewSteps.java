package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utils.CommonMethods;

import java.io.IOException;

public class ReviewSteps extends CommonMethods {

    @Given("the user is navigated to HRMS application")
    public void the_user_is_navigated_to_hrms_application() throws IOException {
        openBrowserAndLaunchApplication();
    }

    @When("user enters {string} value and {string} value")
    public void user_enters_value_and_value(String username, String password) {
        sendText(username, loginPage.usernameTextField);
        sendText(password, loginPage.passwordTextField);
    }

    @When("user enters {string} values and {string} values")
    public void user_enters_values_and_values(String username, String password) {
        sendText(username, loginPage.usernameTextField);
        sendText(password, loginPage.passwordTextField);
    }
}
