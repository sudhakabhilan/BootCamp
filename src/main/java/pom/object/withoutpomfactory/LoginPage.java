package pom.object.withoutpomfactory;

import javafx.css.CssMetaData;
import javafx.css.Styleable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage
{
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void enterUserName() {
        driver.findElement(By.id("username")).sendKeys("matschie@testleaf.com");
    }

    public void enterPassword() {
        driver.findElement(By.id("password")).sendKeys("BootcampSel$123");
    }

    public void clickLogin() {
        driver.findElement(By.id("Login")).click();
    }
}
