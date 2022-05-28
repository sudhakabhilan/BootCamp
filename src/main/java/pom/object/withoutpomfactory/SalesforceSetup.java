package pom.object.withoutpomfactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SalesforceSetup {

    private WebDriver driver;

    public  SalesforceSetup(WebDriver driver){
        this.driver = driver;
    }
    public void clickSales(){

        driver.findElement(By.className("slds-r6")).click();
    }

}
