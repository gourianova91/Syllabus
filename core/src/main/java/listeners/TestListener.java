package listeners;

import driver.Driver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;

import java.io.File;
import java.io.IOException;

public class TestListener implements ITestListener, ISuiteListener, IInvokedMethodListener
{
    String filePath = "C:\\Projects\\Test\\Syllabus\\screenshots";

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        //
    }

    public void takeScreenShot(String methodName) {
        //get the driver
        File scrFile = ((TakesScreenshot) Driver.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in drive with test method name
        try {
            FileUtils.copyFile(scrFile, new File(filePath+methodName+".png"));
            System.out.println("***Placed screen shot in "+filePath+" ***");
        } catch (IOException e) {
            System.out.println("=======================================================================");
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult var1){
        //
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        //
    }

    @Override
    public void onTestFailure(ITestResult result){
        System.out.println("***** Error "+result.getName()+" test has failed *****");
        String methodName=result.getName().toString().trim();
        takeScreenShot(methodName);
    }

    @Override
    public void onTestSuccess(ITestResult var1){
        //
    }

    @Override
    public void onStart(ITestContext var1){
        //
    }

    @Override
    public void onFinish(ITestContext var1){
        //
    }

    @Override
    public void onStart(ISuite arg0) {
        //
    }

    @Override
    public void onFinish(ISuite arg0) {
        //
    }

    public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
        //
    }

    public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {
        //
    }

}
