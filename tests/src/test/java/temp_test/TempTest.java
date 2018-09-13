package temp_test;

import listeners.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import setup.SetUp;

@Listeners(TestListener.class)
public class TempTest extends SetUp {

    @Test
    public void someTest()
    {
        tempPage.navigateTo("https://www.onliner.by/");
    }

}
