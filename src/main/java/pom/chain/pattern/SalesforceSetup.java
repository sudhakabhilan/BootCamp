package pom.chain.pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SalesforceSetup {

    WebDriver driver;
    public SalesforceSetup(WebDriver driver){
        this.driver = driver;
    }



    public AppLauncher clickSales() throws InterruptedException {
        Thread.sleep(7000);
        driver.findElement(By.className("slds-r6")).click();
        return new AppLauncher(driver);
    }

}
