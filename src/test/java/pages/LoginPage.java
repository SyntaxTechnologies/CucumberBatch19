package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;
import utils.ConfigReader;

import java.io.IOException;

public class LoginPage extends CommonMethods {

    @FindBy(xpath="//*[@id='txtUsername']")
    public WebElement usernameTextField;

    @FindBy(id="txtPassword")
    public WebElement passwordTextField;

    @FindBy(id="btnLogin")
    public WebElement loginButton;

    public void enterUsername() throws IOException {
        sendText(ConfigReader.read("userName"),loginPage.usernameTextField);
    }

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }


}
