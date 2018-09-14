package temp_test;

import org.testng.annotations.Test;
import setup.SetUp;
import temp_page.TempPage;

public class TempTest extends SetUp {

    private TempPage tempPage;

    @Test( groups = { "regression" })
    public void failedTest()
    {
        tempPage = new TempPage();
        tempPage.goTo("https://www.onliner.by/");
        tempPage.searchIn();
    }

    @Test(groups = {"smoke" })
    public void passedTest()
    {
        tempPage = new TempPage();
        tempPage.goTo("https://www.onliner.by/");
    }
}
