package pom.chain.pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage

{
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }


    public LoginPage enterUserName() throws InterruptedException {

        driver.findElement(By.id("username")).sendKeys("matschie@testleaf.com");
        Thread.sleep(5000);
        return this;
    }

    public LoginPage enterPassword() {
        driver.findElement(By.id("password")).sendKeys("BootcampSel$123");
        return this;

    }

    public SalesforceSetup clickLogin() throws InterruptedException {
        driver.findElement(By.id("Login")).click();
        Thread.sleep(5000);
        return new SalesforceSetup(driver);
    }
}
