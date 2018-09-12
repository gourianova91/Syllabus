package temp_test;

import org.testng.annotations.Test;
import setup.SetUp;

public class TempTest extends SetUp {

    @Test
    public void someTest()
    {
        tempPage.navigateTo("https://www.onliner.by/");
    }

    @Test
    public void failedTest()
    {
        tempPage.navigateTo("https://www.onliner.by");
        tempPage.searchIn();
    }
}
