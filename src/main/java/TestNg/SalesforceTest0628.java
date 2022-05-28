package TestNg;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class SalesforceTest0628 extends TestNgInitiate{


    @DataProvider
    public Object[][] dataProv(){
        Object[][] dataProv = new Object[2][2];
        dataProv[0][0] ="Sales";
        dataProv[0][1]= "04/03/2022";
        dataProv[1][0] = "Sales";
        dataProv[1][1] = "05/03/2022";
        return dataProv;
    }
    @Test(dataProvider = "dataProv")
    public void SalesforceTest0628Test(String inputvalue , String date) throws InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder='Search apps and items...']")).sendKeys(inputvalue);

        driver.findElement(By.xpath("(//b[text()='Sales'])[3]")).click();


        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//span[@class='slds-truncate'])[3]")));


        driver.findElement(By.xpath("//div[@title='New']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("(//input[@class='slds-input'])[3]")).sendKeys(date);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='slds-button slds-button_brand']"))).click();
        //driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
        String asserttext = "Complete this field.";
        String stage = driver.findElement(By.xpath("(//div[@class='slds-form-element__help'])[2]")).getText();
        String OpportunityName = driver.findElement(By.xpath("//div[@class='slds-form-element__help']")).getText();
        Assert.assertEquals(stage,asserttext);
        Assert.assertEquals(OpportunityName,asserttext);

    }


}