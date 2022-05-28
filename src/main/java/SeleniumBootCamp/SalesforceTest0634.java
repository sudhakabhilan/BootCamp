package SeleniumBootCamp;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.sql.Driver;
import java.time.Duration;

public class SalesforceTest0634
{

    public static void main(String[] args) throws InterruptedException {
        //WebDriverManager.chromedriver.setup();
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



        Driver.findElement(By.xpath("//button[text()='View All']")).click();
        ((JavascriptExecutor) Driver).executeScript("arguments[0].scrollIntoView();",Driver.findElement(By.xpath("//a[@data-label='Legal Entities']")));
        ((JavascriptExecutor) Driver).executeScript("arguments[0].click();",Driver.findElement(By.xpath("//a[@data-label='Legal Entities']")));



        Driver.findElement(By.xpath("(//div[@title='New'])")).click();
        Thread.sleep(3000);
                String legalentityname = "Salesforce Automation by Sudhakaran";
                Driver.findElement(By.xpath("//input[@class=' input']")).sendKeys(legalentityname);
               Driver.findElement(By.xpath("//button[@title='Save']")).click();
               Driver.findElement(By.xpath("//Span[text() = 'Salesforce Automation by Sudhakaran']")).getText().equals(legalentityname);
                Driver.quit();
       }


    }
