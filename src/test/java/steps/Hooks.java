package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.CommonMethods;

import java.io.IOException;

public class Hooks extends CommonMethods {

    //pre condition
    @Before
    public void start() throws IOException {
        openBrowserAndLaunchApplication();
    }

    //post condition
    @After
    public void end(Scenario scenario){
        byte[] pic;
        //getname is the method in scenario class which returns the name of the test case
        if(scenario.isFailed()){
            pic = takeScreenshot("failed/"+scenario.getName());
        }else{
           pic = takeScreenshot("passed/"+scenario.getName());
        }

        //this will attach my screenshot to my report
        scenario.attach(pic,"image/png",scenario.getName());

        closeBrowser();
    }

}
