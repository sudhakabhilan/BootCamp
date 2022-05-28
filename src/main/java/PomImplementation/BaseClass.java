package PomImplementation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {


    ChromeDriver driver;
    JavascriptExecutor js;
    WebDriverWait wait;
   public  FileInputStream read;
   public  Properties   prop;



    @BeforeMethod
    public void SalesforceTest_Launchbrowser() throws InterruptedException, IOException {
         read = new FileInputStream("src/main/java/PomImplementation/NewConfig.Properties");
        //Create Properties Object
          prop = new Properties();

        //Load Properties file into the Prop object
        prop.load(read);
        //Define Webdriver using Webdrivermanager
        WebDriverManager.chromedriver().setup();
        //Chromeoptions to disable notifications
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();

        driver.get(prop.getProperty("url"));
        driver.findElement(By.id("username")).sendKeys(prop.getProperty("username"));
        driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
        driver.findElement(By.id("Login")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.className("slds-r6")).click();


    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    }
