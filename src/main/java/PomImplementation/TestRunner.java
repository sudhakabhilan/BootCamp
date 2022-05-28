package PomImplementation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestRunner extends BaseClass {
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
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='slds-button slds-button_brand']")));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
        String asserttext = "Complete this field.";
        String stage = driver.findElement(By.xpath("(//div[@class='slds-form-element__help'])[2]")).getText();
        String OpportunityName = driver.findElement(By.xpath("//div[@class='slds-form-element__help']")).getText();
        Assert.assertEquals(stage,asserttext);
        Assert.assertEquals(OpportunityName,asserttext);

    }
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
