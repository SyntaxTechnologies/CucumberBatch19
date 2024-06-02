package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //this will specify the path of features directory
        features = "src/test/resources/features/",
        //here in glue, we provide the name of the steps package
        //runner class will search all the step definitions inside this package
        glue = "steps",
        //when we set the value of dry run to true
        //it stops the actual execution and scans all the step definitions,
        //if the step def is missing in any of the class, then it will give you that
        //missing step def. if all the step def are there, it will provide green tick

        //to start the actual execution after implementing the missing step
        //set the value of dry run to false
        dryRun = false,
        tags = "@regression",
        //pretty keywords prints all the steps in console which we execute
        //to generate the report, i need to mention type of report and location
        plugin = {"pretty","html:target/cucumber.html","json:target/cucumber.json"}
)

public class RegressionRunner {
}
