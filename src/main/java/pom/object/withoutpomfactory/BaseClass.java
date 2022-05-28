package pom.object.withoutpomfactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class BaseClass {


    ChromeDriver driver;
    JavascriptExecutor js;
    WebDriverWait wait;
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
        page  = new LoginPage(driver);
        ssetup = new SalesforceSetup(driver);
        alaunch = new AppLauncher(driver);
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();

        driver.get("https://login.salesforce.com");
        page.enterUserName();
        page.enterPassword();
        page.clickLogin();
        Thread.sleep(5000);
        ssetup.clickSales();




    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    }
