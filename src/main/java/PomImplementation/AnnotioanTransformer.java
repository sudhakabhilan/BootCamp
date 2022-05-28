package PomImplementation;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotioanTransformer implements IAnnotationTransformer {

    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
           // annotation.setRetryAnalyzer(TestNGRetry.class);

        annotation.setRetryAnalyzer(TestNGRetry.class);
    }
}
