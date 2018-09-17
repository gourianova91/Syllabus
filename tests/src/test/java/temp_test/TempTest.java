package temp_test;

import listeners.TestListener;
import org.testng.annotations.Listeners;
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
        System.out.println("Simple test-method One. Thread id is: " + id);
        tempPage = new TempPage();
        tempPage.goTo("https://www.onliner.by/");
        tempPage.searchIn();
    }

    @Test(groups = {"smoke" })
    public void passedTest()
    {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method One. Thread id is: " + id);
        tempPage = new TempPage();
        tempPage.goTo("https://www.onliner.by/");
    }
}
