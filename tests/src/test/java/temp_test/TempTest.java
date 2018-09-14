package temp_test;

import org.testng.annotations.Test;
import setup.SetUp;

public class TempTest extends SetUp {

    @Test(groups = { "regression" })
    public void failedTest()
    {
        tempPage.goTo("https://www.onliner.by/");
        tempPage.searchIn();
    }

    @Test(groups = { "smoke" })
    public void passedTest()
    {
        tempPage.goTo("https://www.onliner.by/");
    }
}
