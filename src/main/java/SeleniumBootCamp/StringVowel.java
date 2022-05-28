package SeleniumBootCamp;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class StringVowel
{

    public static void main(String[] args) throws InterruptedException {
        String str = "Selenium WeDriver is a powerful web automation tool";
        String vowels = "aeiou";

        char chars[] = vowels.toCharArray();
        System.out.println(chars);
        char charstr[] = str.toCharArray();

                for(int i = 0;i<charstr.length;i++){
                    if(charstr[i]!= ' ' && (i ==0||charstr[i-1]==' ')){
                        System.out.println(charstr[i]);
                       
                    }
                }








    }
}