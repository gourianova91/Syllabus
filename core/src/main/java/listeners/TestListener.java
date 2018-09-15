package listeners;

import driver.DriverFactory;
import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.*;

public class TestListener implements ITestListener, ISuiteListener, IInvokedMethodListener
{
    /*This belongs to ISuiteListener and will execute before the Suite Starts*/
    @Override
    public void onStart(ISuite arg0) {
        Reporter.log("Execution of the Suite '" + arg0.getName() + "' Started!", false);
    }

    /*This belongs to ISuiteListener and will execute after the Suite Ends*/
    @Override
    public void onFinish(ISuite arg0) {
        Reporter.log("Execution of the Suite '" + arg0.getName() + "' Completed!", false);
    }

    /*This belongs to ITestListener, It will execute at the time of Test Execution */
    @Override
    public void onStart(ITestContext var1){
        Reporter.log("About to begin executing Test " + var1.getName(), false);
    }

    /*This belongs to ITestListener, It will execute at the End of Test*/
    @Override
    public void onFinish(ITestContext var1){
        Reporter.log("Completed executing test " + var1.getName(), false);
    }

    /*This belongs to ITestListener, It will Execute only when the Test is PASSED*/
    @Override
    public void onTestSuccess(ITestResult result){
        Reporter.log("\nSUCCESFULLY EXECUTED TEST: " + result.getTestClass().getName() + "." + result.getMethod().getMethodName() + "\n", true);Reporter.log("\n");
    }

    /*This belongs to ITestListener, It will Execute only when the Test is FAILED*/
    @Override
    public void onTestFailure(ITestResult result){
        Reporter.log("\nFAILED TEST: " + result.getTestClass().getName() + "." + result.getMethod().getMethodName() + "\n", true);
        String Name = result.getTestClass().getName() + "." + result.getMethod().getMethodName();
        //if (Driver.isDriverRunning()) {
            AllureAttachments.takeScreenShot(Name);
        //}
    }

    /*This belongs to ITestListener, It and will execute before the Main Test Starts (@Test)*/
    @Override
    public void onTestStart(ITestResult result){
        Reporter.log("\nSTARTED TESTING: " + result.getTestClass().getName() + "." + result.getMethod().getMethodName() + "\n", true);
    }

    /*This belongs to ITestListener, It will execute only if any of the Main Test(@Test) Gets Skipped*/
    @Override
    public void onTestSkipped(ITestResult result) {
        Reporter.log("\nSKIPPED TEST: " + result.getTestClass().getName() + "." + result.getMethod().getMethodName() + "\n", true);
    }

    /*This belongs to IInvokedMethodListener, It will execute before every method Including @Before @After @Test*/
    public void beforeInvocation(IInvokedMethod method, ITestResult arg1) {
        String textMsg = "About to begin executing following method : " + returnMethodName(method.getTestMethod());
        Reporter.log(textMsg, false);
        if (method.isTestMethod()) {
            String browserName = method.getTestMethod().getXmlTest().getLocalParameters().get("browserName");
            WebDriver driver = DriverFactory.createBrowser(browserName);
            DriverManager.setWebDriver(driver);
        }
    }

    /*This belongs to IInvokedMethodListener and will execute after every method Including @Before @After @Test*/
    public void afterInvocation(IInvokedMethod method, ITestResult arg1) {
        String textMsg = "Completed executing following method : " + returnMethodName(method.getTestMethod());
        Reporter.log(textMsg, false);
      /*  if (method.isTestMethod()) {
            WebDriver driver = DriverManager.getDriver();
            if (driver != null) {
                driver.quit();
            }
        }*/
    }

    /*This will return method names to the calling function*/
    private String returnMethodName(ITestNGMethod method)
    {
        return method.getRealClass().getSimpleName() + "." + method.getMethodName();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) { }

}
