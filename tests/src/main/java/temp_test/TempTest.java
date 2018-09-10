package temp_test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import temp_page.TempPage;

public class TempTest {

    TempPage tempPage = new TempPage();

    @Test
    public void someTest()
    {
        tempPage.navigateTo("https://www.onliner.by/");
    }

    @AfterTest
    public void tearDown()
    {
        tempPage.closeBrowser();
    }

}
