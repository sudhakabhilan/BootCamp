package TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

public class SalesforceTest0675
{

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver_win32 (1)\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver Driver = new ChromeDriver(options);
        JavascriptExecutor js = (JavascriptExecutor) Driver;

        Driver.manage().window().maximize();

        String url = "https://login.salesforce.com";

        Driver.get(url);
        Driver.findElement(By.id("username")).sendKeys("matschie@testleaf.com");
        Driver.findElement(By.id("password")).sendKeys("BootcampSel$123");
        Driver.findElement(By.id("Login")).click();

        Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(3000);
        String heading = "See System Status";
        List<WebElement> headers = Driver.findElements(By.xpath("//article[@class = 'onesetupHelpTile']"));
        Iterator<WebElement> itr = headers.iterator();
//       while(itr.hasNext()){
//           for(i=0; i<3;i++)
//            Driver.findElement(By.xpath("//button[@class = 'slds-button slds-button--neutral rightArrowButton uiButton']")).click();
//        }
//           if(Driver.findElement(By.xpath("//span[text() = 'See System Status']")).getText() !=heading){
//               Driver.findElement(By.xpath("//button[@class = 'slds-button slds-button--neutral rightArrowButton uiButton']")).click();
//       }else{
//               Driver.findElement(By.xpath("//div[@id='setupHomeCarousel_page3']/article[3]/div[3]/div[3]/button[1]/span[1]")).click();
//           }
}
//        if(Driver.findElement(By.xpath("//span[text() = 'See System Status']")).getText() !=heading){
//            Driver.findElement(By.xpath("//button[@class = 'slds-button slds-button--neutral rightArrowButton uiButton']")).click();
//        }if(Driver.findElement(By.xpath("//span[text() = 'See System Status']")).getText() !=heading){
//            Driver.findElement(By.xpath("//button[@class = 'slds-button slds-button--neutral rightArrowButton uiButton']")).click();
//            Driver.findElement(By.xpath("//div[@id='setupHomeCarousel_page3']/article[3]/div[3]/div[3]/button[1]/span[1]")).click();
//        }





    }
