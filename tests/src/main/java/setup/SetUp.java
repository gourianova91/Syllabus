package setup;

import driver.Driver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import temp_page.TempPage;

public class SetUp {

    protected TempPage tempPage;

    @BeforeSuite
    public void setupSuite()
    {
        tempPage = new TempPage();
    }

    @AfterSuite
    public void tearDownSuite()
    {
        Driver.getInstance().destroyDriver();
    }
}
