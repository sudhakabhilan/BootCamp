package pom.chain.pattern;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class BaseClass {


    WebDriver driver;
    //JavascriptExecutor js;
   // public WebDriverWait wait;
    LoginPage page;
    SalesforceSetup ssetup;
    AppLauncher alaunch;


    @BeforeMethod
    public void SalesforceTest_Launchbrowser() throws InterruptedException, IOException {

        //Define Webdriver using Webdrivermanager
        WebDriverManager.chromedriver().setup();
        //Chromeoptions to disable notifications
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);

       // js = (JavascriptExecutor) driver;

        driver.manage().window().maximize();

        driver.get("https://login.salesforce.com");

        Thread.sleep(5000);
        new LoginPage(driver)
                .enterUserName()
                .enterPassword()
                .clickLogin();



    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    }
