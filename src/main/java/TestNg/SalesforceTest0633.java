package TestNg;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SalesforceTest0633 extends TestNgInitiate{


    @Test
    public void SalesforceTest0633Test() throws InterruptedException {
        driver.findElement(By.className("slds-r6")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//a[@data-label='Accounts']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@data-label='Accounts']")));
        driver.findElement(By.xpath("//div[@class = 'slds-dropdown-trigger slds-dropdown-trigger_click']")).click();
        Thread.sleep(3000);
        //Get the list of Elements from the drop down
        List<WebElement> Li = driver.findElements(By.xpath("//a[@role = 'option']"));

        //Click on the All Accounts
        for (WebElement all : Li) {

            if (all.getText().equals("All Accounts")) {
                all.click();
                break;
            }
        }
        // Get the List of Values from the List present into List of Web Elements and Sort it
        Thread.sleep(5000);
        List<WebElement> listofaccounts = driver.findElements(By.xpath("//a[contains(@class,'slds-truncate outputLookupLink')]"));
        List<String> sortedlistinitial = new ArrayList<String>();
        for(WebElement ele:  listofaccounts){

            sortedlistinitial.add(String.valueOf(ele.getText()));

        }

        Collections.sort(sortedlistinitial);
        System.out.println(sortedlistinitial);

        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[@title = 'Account Name']")).click();
        List<WebElement> listofaccountssorted = driver.findElements(By.xpath("//a[contains(@class,'slds-truncate outputLookupLink')]"));
        List<String> sortedlistend = new ArrayList<String>();
        for(WebElement elenew:  listofaccountssorted){

            sortedlistend.add(String.valueOf(elenew.getText()));
            System.out.println(sortedlistend);
        }

        Assert.assertEquals(sortedlistend,sortedlistinitial);
//        if (sortedlistend.equals(sortedlistinitial)== true) {
//
//            System.out.println("Success");
//        }
    }



}




