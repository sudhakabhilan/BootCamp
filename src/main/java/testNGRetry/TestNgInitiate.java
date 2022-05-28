package testNGRetry;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class TestNgInitiate {


    ChromeDriver driver;
    JavascriptExecutor js;
    WebDriverWait wait;


    @Parameters({"URL","username","password"})
    @BeforeMethod

    public void SalesforceTest_Launchbrowser( String url, String user, String pass) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        //String url = "https://login.salesforce.com";
        driver.get(url);
        driver.findElement(By.id("username")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.id("Login")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.className("slds-r6")).click();


    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    }
