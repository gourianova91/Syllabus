package setup;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class SetUp {

    @AfterMethod
    public void tearDownMethod()
    {
        WebDriver driver = DriverManager.getDriver();
        if (driver != null) {
            driver.quit();
        }
    }

}
