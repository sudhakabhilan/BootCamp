package testNGRetry;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestNGRetry implements IRetryAnalyzer {


    int count = 0;
    int limit = 4;
    public boolean retry(ITestResult iTestResult) {
        if(count<limit){
            count++;
            return true;
        }
        return false;
    }
}
