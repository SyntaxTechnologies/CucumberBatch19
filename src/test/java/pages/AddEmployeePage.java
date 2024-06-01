package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {

    //find by class will be used to identify the webelement using id here
    //firstNameloc is the key which we will call in scripts
    //object repository is nothing but the locators you keep in page class

    @FindBy(id="firstName")
    public WebElement firstNameLoc;

    @FindBy(id="middleName")
    public WebElement middleNameLoc;

    @FindBy(id="lastName")
    public WebElement lastNameLoc;

    @FindBy(id="btnSave")
    public WebElement saveButton;

    @FindBy(id="photofile")
    public WebElement photograph;

    @FindBy(id="chkLogin")
    public WebElement checkBox;

    @FindBy(id="user_name")
    public WebElement username;

    @FindBy(id="user_password")
    public WebElement passwordUser;

    @FindBy(id="re_password")
    public WebElement confirmPasswordUser;

    public AddEmployeePage(){
        PageFactory.initElements(driver,this);
    }



}
