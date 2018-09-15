package listeners;

import driver.DriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import selenium_methods.Webelement;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AllureAttachments {

    @Attachment(value = "Screenshot of {0}", type="image/png")
    public static byte[] takeScreenShot(String name)
    {
        /*Screenshot viewable area by AShot*/
        Screenshot entirePageScreenShot = new AShot().takeScreenshot(DriverManager.getDriver());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(entirePageScreenShot.getImage(),"PNG", baos);
            baos.flush();
            byte[] imageInByte = baos.toByteArray();
            baos.close();
            return imageInByte;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Unable to Get Screenshot.".getBytes();
    }

    @Attachment(value="EntirePage Screenshot of {0}", type="image/png")
    public static byte[] takeScreenShotEntirePage(String name) {
        /*Take Screenshot of entire page by AShot*/
        Screenshot entirePageScreenShot = new AShot().
                shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(DriverManager.getDriver());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(entirePageScreenShot.getImage(),"PNG", baos);
            baos.flush();
            byte[] imageInByte = baos.toByteArray();
            baos.close();
            return imageInByte;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Unable to Get Screenshot.".getBytes();
    }

    @Attachment(value="Screenshot of WebElement {1} in test {0}", type="image/png")
    public static byte[] takeScreenShotWebelement(String name, By locator) {
        /*Take Screenshot of WebElement by AShot*/
        Webelement webelement = new Webelement();
        WebElement element = webelement.WaitUntilExist(locator);
        Screenshot entirePageScreenShot = new AShot().takeScreenshot(DriverManager.getDriver(), element);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(entirePageScreenShot.getImage(),"PNG", baos);
            baos.flush();
            byte[] imageInByte = baos.toByteArray();
            baos.close();
            return imageInByte;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Unable to Get Screenshot.".getBytes();
    }

    /*To Convert the File to Bytes*/
    private static byte[] fileToBytes(String fileName) throws Exception
    {
        File file = new File(fileName);
        return Files.readAllBytes(Paths.get(file.getAbsolutePath()));
    }

    /*To Attach the PNG Image File to the Allure Report*/
    @Attachment(value="PNG Attachment", type = "image/png")
    public static byte[] attachFileType_PNG(String filePath) throws Exception
    {
        return fileToBytes(filePath);
    }
}
