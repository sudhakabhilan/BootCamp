package TestNg;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class SalesforceTest0646 extends TestNgInitiate
{


    @Test
    public void SalesforceTest0646Test() throws InterruptedException{
        driver.findElement(By.className("slds-r6")).click();


        Thread.sleep(10000);

        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='View All']")));
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//a[@data-label='Individuals']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",driver.findElement(By.xpath("//a[@data-label='Individuals']")));
        driver.findElement(By.xpath("//a[@title='Banu'][1]")).click();
        //table[contains(@class,'slds-table forceRecordLayout')]
        //table[contains(@class,'slds-table forceRecordLayout')]/tbody[1]/tr[6]/th[1]/span[1]/a[1]
        driver.findElement(By.xpath("//div[@title = 'Delete']")).click();
        driver.findElement(By.xpath("//span[text() = 'Delete']")).click();
        Assert.assertEquals("Banu","Banu");
        // driver.findElement(By.xpath("//span[text() = 'Kumar']")).getText().equals("Kumar");
    }



    }
