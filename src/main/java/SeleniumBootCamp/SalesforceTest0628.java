package SeleniumBootCamp;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.sql.Driver;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

public class SalesforceTest0628
{

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver_win32 (1)\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver Driver = new ChromeDriver(options);
        JavascriptExecutor js = (JavascriptExecutor) Driver;

        Driver.manage().window().maximize();

        String url = "https://login.salesforce.com";

        Driver.get(url);
        Driver.findElement(By.id("username")).sendKeys("matschie@testleaf.com");
        Driver.findElement(By.id("password")).sendKeys("BootcampSel$123");
        Driver.findElement(By.id("Login")).click();

        Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Driver.findElement(By.className("slds-r6")).click();

        Driver.findElement(By.xpath("//input[@placeholder='Search apps and items...']")).sendKeys("Sales");

    Driver.findElement(By.xpath("(//b[text()='Sales'])[3]")).click();



        js.executeScript("arguments[0].click();",Driver.findElement(By.xpath("(//span[@class='slds-truncate'])[3]")));


        Driver.findElement(By.xpath("//div[@title='New']")).click();
        Thread.sleep(3000);

                Driver.findElement(By.xpath("(//input[@class='slds-input'])[3]")).sendKeys("4/3/2022");
               Driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
               String asserttext = "Complete this field.";
                boolean stage = Driver.findElement(By.xpath("(//div[@class='slds-form-element__help'])[2]")).getText().equals(asserttext);
                boolean OpportunityName =  Driver.findElement(By.xpath("//div[@class='slds-form-element__help']")).getText().equals(asserttext);
                if (stage == true){
                    System.out.println("For Stage - Complete this field message is displayed");
                }
        if (OpportunityName == true){
            System.out.println("For Opportunity name - Complete this field message is displayed");
        }
             Driver.quit();

    }
}