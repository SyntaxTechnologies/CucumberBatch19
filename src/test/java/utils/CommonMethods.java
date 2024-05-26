package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class CommonMethods {

    public static  WebDriver driver;
    public static void openBrowserAndLaunchApplication() throws IOException {

        switch (ConfigReader.read("browser")){
            case "Chrome":
                driver=new ChromeDriver();
                break;
            case "FireFox":
                driver=new FirefoxDriver();
                break;
            case "Edge":
                driver=new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Invalid Browser Name");
        }
//        impicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get(ConfigReader.read("url"));
    }

    public static void closeBrowser(){
        if(driver!=null){
        driver.quit();
        }
    }

    public  static  void selectFromDropDown(WebElement dropDown,int index){
        Select sel=new Select(dropDown);
        sel.selectByIndex(index);
    }
    public  static  void selectFromDropDown(WebElement dropDown,String visibleText){
        Select sel=new Select(dropDown);
        sel.selectByVisibleText(visibleText);
    }

    public  static  void selectFromDropDown(String value, WebElement dropDown){
        Select sel=new Select(dropDown);
        sel.selectByValue(value);
    }

    public static void sendText(String text,WebElement element){
//        clear the text box
        element.clear();
//        send the text to element
        element.sendKeys(text);
    }


    public  static  WebDriverWait getwait(){
    WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
    return  wait;
    }

    public static void waitForElementToBeClickable(WebElement element){
        getwait().until(ExpectedConditions.elementToBeClickable(element));

    }

    public static void click(WebElement element){
        waitForElementToBeClickable(element);
        element.click();
    }

    //take screenshot
    //checkboxes
    //radiobuttons
    //jsclick



}
