package temp_test;

import org.testng.annotations.Test;
import setup.SetUp;

public class TempTest extends SetUp {

    @Test
    public void failedTest()
    {
        tempPage.goTo("https://www.onliner.by/");
        tempPage.searchIn();
    }

    @Test
    public void passedTest()
    {
        tempPage.goTo("https://www.onliner.by/");
    }
}
