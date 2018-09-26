package temp_test;

import listeners.TestListener;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import setup.SetUp;
import temp_page.TempPage;

@Listeners(TestListener.class)
public class TempTest extends SetUp {

    private TempPage tempPage;

    @Test( groups = { "regression" })
    public void failedTest()
    {
        long id = Thread.currentThread().getId();
        System.out.println("failedTest. Thread id is: " + id);
        tempPage = new TempPage();
        tempPage.goTo("https://www.onliner.by/");
        tempPage.searchIn();
    }

    @Test(groups = {"smoke" })
    public void passedTest()
    {
        long id = Thread.currentThread().getId();
        System.out.println("passedTest. Thread id is: " + id);
        tempPage = new TempPage();
        tempPage.goTo("https://www.onliner.by/");
    }

    @Test
    @Parameters({"smartPhone", "pc", "laptop"})
    public void parametrizedTest(String smartPhone, String pc, String laptop)
    {
        long id = Thread.currentThread().getId();
        System.out.println("parametrizedTest. Thread id is: " + id);
        tempPage = new TempPage();
        tempPage.goTo("https://www.onliner.by/");
        tempPage.searchFor(smartPhone);
        tempPage.searchFor(pc);
        tempPage.searchFor(laptop);
    }

    @DataProvider(parallel = true)
    public Object[] setSmartNames()
    {
        return new Object[]{ "Huawei", "Xiaomi", "Samsung"};
    }

    @Test(dataProvider = "setSmartNames")
    public void testWithDataProvider(String smartName)
    {
        long id = Thread.currentThread().getId();
        System.out.println("testWithDataProvider. Thread id is: " + id);
        tempPage = new TempPage();
        tempPage.goTo("https://www.onliner.by/");
        tempPage.searchFor(smartName);
    }
}
