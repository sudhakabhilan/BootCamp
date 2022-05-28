package pom.chain.pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppLauncher  extends BaseClass{

    WebDriver driver;


    //JavascriptExecutor js;

    public AppLauncher(WebDriver driver){
        this.driver = driver;
    }


    public AppLauncher clickSales() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//b[text()='Sales'])[3]")).click();
        return this;
    }

    public AppLauncher searchAppLauncher() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //driver.findElement(By.xpath("//input[@placeholder='Search apps and items...']")).sendKeys("Sales");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search apps and items...']"))).sendKeys("Sales");
       Thread.sleep(10000);

        return this;
    }

    public AppLauncher selectSales()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;


        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//p[@class='slds-truncate']//b)[3]")));
        return this;
    }
}