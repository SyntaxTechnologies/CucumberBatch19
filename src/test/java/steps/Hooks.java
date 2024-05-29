package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
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
    public void end(){
        closeBrowser();
    }

}
