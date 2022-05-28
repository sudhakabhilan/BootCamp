package pom.object.withoutpomfactory;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
        Thread.sleep(10000);
            alaunch.searchAppLauncher(inputvalue);
            alaunch.clickSales();



        Thread.sleep(10000);
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

}
