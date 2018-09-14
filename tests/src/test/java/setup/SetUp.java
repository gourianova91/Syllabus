package setup;

import driver.Driver;
import org.testng.annotations.AfterMethod;

public class SetUp {

    @AfterMethod(alwaysRun = true)
    public void tearDownSuite()
    {
        Driver.getInstance().destroyDriver();
    }

}
