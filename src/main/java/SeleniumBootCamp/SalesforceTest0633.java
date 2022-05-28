package SeleniumBootCamp;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;



import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
public class SalesforceTest0633 {

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

        Thread.sleep(2000);
        Driver.findElement(By.xpath("//button[text()='View All']")).click();
        ((JavascriptExecutor) Driver).executeScript("arguments[0].scrollIntoView();", Driver.findElement(By.xpath("//a[@data-label='Accounts']")));
        ((JavascriptExecutor) Driver).executeScript("arguments[0].click();", Driver.findElement(By.xpath("//a[@data-label='Accounts']")));
        Driver.findElement(By.xpath("//div[@class = 'slds-dropdown-trigger slds-dropdown-trigger_click']")).click();
        Thread.sleep(3000);
        //Get the list of Elements from the drop down
        List<WebElement> Li = Driver.findElements(By.xpath("//a[@role = 'option']"));

        //Click on the All Accounts
        for (WebElement all : Li) {

            if (all.getText().equals("All Accounts")) {
                all.click();
                break;
            }
        }
        // Get the List of Values from the List present into List of Web Elements and Sort it
Thread.sleep(5000);
        List<WebElement> listofaccounts = Driver.findElements(By.xpath("//a[contains(@class,'slds-truncate outputLookupLink')]"));
        List<String> sortedlistinitial = new ArrayList<String>();
            for(WebElement ele:  listofaccounts){

                sortedlistinitial.add(String.valueOf(ele.getText()));
            }

        Collections.sort(sortedlistinitial);

      Thread.sleep(3000);
       Driver.findElement(By.xpath("//span[@title = 'Account Name']")).click();
       List<WebElement> listofaccountssorted = Driver.findElements(By.xpath("//a[contains(@class,'slds-truncate outputLookupLink')]"));
          List<String> sortedlistend = new ArrayList<String>();
           for(WebElement elenew:  listofaccountssorted){

               sortedlistend.add(String.valueOf(elenew.getText()));
               System.out.println(sortedlistend);
            }

        if (sortedlistend.equals(sortedlistinitial)== true) {

                System.out.println("Success");
            }

        Driver.quit();


    }
}




