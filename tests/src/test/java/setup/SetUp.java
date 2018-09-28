package setup;

import driver.DriverManager;
import org.testng.annotations.AfterMethod;

public class SetUp {

    @AfterMethod (alwaysRun = true)
    public void tearDownMethod()
    {
        long id = Thread.currentThread().getId();
        System.out.println("tearDownMethod. Thread id is: " + id);
        if (DriverManager.getWebDriver() != null) {
            DriverManager.getWebDriver().quit();
            DriverManager.removeWebDriver();
            id = Thread.currentThread().getId();
            System.out.println("tearDownMethod. Remove thread id is: " + id);
        }
    }
}
