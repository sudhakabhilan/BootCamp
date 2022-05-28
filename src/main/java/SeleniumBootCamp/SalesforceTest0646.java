package SeleniumBootCamp;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class SalesforceTest0646
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
        ((JavascriptExecutor) Driver).executeScript("arguments[0].scrollIntoView();",Driver.findElement(By.xpath("//a[@data-label='Individuals']")));
        ((JavascriptExecutor) Driver).executeScript("arguments[0].click();",Driver.findElement(By.xpath("//a[@data-label='Individuals']")));
        Driver.findElement(By.xpath("//a[@title = 'Kumar'][1]")).click();
        Driver.findElement(By.xpath("//div[@title = 'Delete']")).click();
        Driver.findElement(By.xpath("//span[text() = 'Delete']")).click();
        Driver.findElement(By.xpath("//span[text() = 'Kumar']")).getText().equals("Kumar");

                Driver.quit();
       }


    }
