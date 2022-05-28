package TestNg;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SalesforceTest0640
{

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        //System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver_win32 (1)\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver,30);

        driver.manage().window().maximize();

        String url = "https://login.salesforce.com";

        driver.get(url);
        driver.findElement(By.id("username")).sendKeys("matschie@testleaf.com");
        driver.findElement(By.id("password")).sendKeys("BootcampSel$123");
        driver.findElement(By.id("Login")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.className("slds-r6")).click();



        driver.findElement(By.xpath("//button[text()='View All']")).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//a[@data-label='Dashboards']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",driver.findElement(By.xpath("//a[@data-label='Dashboards']")));

        Thread.sleep(3000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//span[@class = 'slds-grid slds-grid_align-spread']//div[@class = 'slds-hyphenate']//a[@title = 'Sales Force Automation']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",driver.findElement(By.xpath("//span[@class = 'slds-grid slds-grid_align-spread']//div[@class = 'slds-hyphenate']//a[@title = 'Sales Force Automation']")));

        Thread.sleep(5000);
        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[text() = 'Edit']")).click();


        Thread.sleep(5000);

        driver.findElement(By.xpath("//button[@title='Edit Dashboard Properties']")).click();
        String descinput = "Salesforce";
        driver.findElement(By.id("dashboardDescriptionInput")).clear();
        driver.findElement(By.id("dashboardDescriptionInput")).sendKeys(descinput);
        driver.findElement(By.id("submitBtn")).click();
        driver.findElement(By.xpath("//button[text()='Done']")).click();
        driver.findElement(By.xpath("(//button[contains(@class,'slds-button slds-button_brand')])[2]")).click();
        String descresult = driver.findElement(By.xpath("//div[@class = 'slds-col slds-align-bottom']/p")).getText();

      if (descinput==descresult){
            System.out.println("Successfully Updated the Description");
        }else{
            System.out.println("Failed to Update the Description");
        }

                driver.quit();
       }


    }
