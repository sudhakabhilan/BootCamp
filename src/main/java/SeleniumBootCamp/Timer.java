package SeleniumBootCamp;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Timer {


    long startTime;
    long endTime;

@Test
    public void startTimer() {

        startTime = System.nanoTime();
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);

    }

}

