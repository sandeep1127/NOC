package WebApp.NOC.testcases;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import WebApp.NOC.BaseClass.WebBase;

public class CustomListener extends WebBase implements ITestListener{           // This class is Implementing ITestListner class which contains the pre made method which we implemented to take screenshot of failed test cases only
	// Here , we just implemented just 1 method of this interface which is to take screenshot of failed test cases
public CustomListener() throws IOException {
super();

}

@Override
public void onTestStart(ITestResult result) {
// TODO Auto-generated method stub

}

@Override
public void onTestSuccess(ITestResult result) {
// TODO Auto-generated method stub

}

@Override
public void onTestFailure(ITestResult result) {
System.out.println("Test case has been failed and screenshot is taken");
try {
screenShotOfFailedCases(result.getMethod().getMethodName());
} catch (IOException e) {

e.printStackTrace();
}

}

@Override
public void onTestSkipped(ITestResult result) {
// TODO Auto-generated method stub

}

@Override
public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
// TODO Auto-generated method stub

}

@Override
public void onStart(ITestContext context) {
// TODO Auto-generated method stub

}

@Override
public void onFinish(ITestContext context) {
// TODO Auto-generated method stub

}

}

