package listeners;

import driver.Driver;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class TestListener implements ITestListener, ISuiteListener, IInvokedMethodListener
{
    //Current Directory
    private static String currentDir = System.getProperty("user.dir");

    //GetScreenShot Method Directory and Image File
    private File getSreenShotMethodImageFile = new File (currentDir +
            "\\ScreenShots\\GetScreenShotMethod\\amazonscreenshot.png");

    //Element Screenshot Directory and Image File
    private File webElementImageFile = new File(currentDir +
            "\\ScreenShots\\Ashot\\WebElement\\logo.png" );

    //Entirepage ScreenShot Directory and Image File
    private File entirePageImageFile = new File(currentDir +
            "\\ScreenShots\\Ashot\\EntirePage\\entirepage.png" );

    @Override
    public void onTestFailure(ITestResult result){
        System.out.println("***** Error "+result.getName()+" test has failed *****");
        String methodName=result.getName().toString().trim();
        if (Driver.isDriverRunning()) {
            Allure.getLifecycle().addAttachment(methodName, "image/png", "png", takeScreenShot());
            //takeScreenShot(methodName);
        }
    }

    //@Attachment(value="EntirePage Screenshot of {0}", type="image/png")
    public static byte[] takeScreenShot() {
        //////////Screenshot viewable area////////////////

        //get the driver
        /*File scrFile = ((TakesScreenshot) Driver.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in drive with test method name
        try {
            //FileUtils.copyFile(scrFile, getSreenShotMethodImageFile);
            FileUtils.copyFile(scrFile, new File(currentDir + "\\ScreenShots\\GetScreenShotMethod\\"+methodName+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        //////////////////////////////////////////////

        //Take Screenshot of entire page by AShot
        Screenshot entirePageScreenShot = new AShot().
                shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(Driver.getInstance().getDriver());
        //Write Screenshot to a file
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(entirePageScreenShot.getImage(),"PNG", baos/*new File(currentDir + "\\ScreenShots\\Ashot\\EntirePage\\"+methodName+".png")*/);
            baos.flush();
            byte[] imageInByte = baos.toByteArray();
            baos.close();
            return imageInByte;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Unable to Get Screenshot.".getBytes();
        //////////////////////////////////////////////
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        //
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
    public void onTestSuccess(ITestResult result){
        System.out.println("***** Success "+result.getName()+" test is OK *****");
        String methodName=result.getName().toString().trim();
        if (Driver.isDriverRunning()) {
            Allure.getLifecycle().addAttachment(methodName, "image/png", "png", takeScreenShot());
            //takeScreenShot(methodName);
        }
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
