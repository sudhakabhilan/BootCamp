package pom.object.withoutpomfactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import java.security.PublicKey;

public class AppLauncher {

    private WebDriver driver;




    public  AppLauncher(WebDriver driver){
        this.driver = driver;
    }

    public void clickSales(){
        driver.findElement(By.xpath("(//b[text()='Sales'])[3]")).click();
    }

    public void searchAppLauncher(String Inputvalue) throws InterruptedException {
      //wait= new WebDriverWait(driver, 10);
        driver.findElement(By.xpath("//input[@placeholder='Search apps and items...']")).sendKeys(Inputvalue);
    }
}
