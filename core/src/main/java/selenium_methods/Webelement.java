package selenium_methods;

import driver.Driver;
import org.openqa.selenium.WebDriver;

public class Webelement {

    WebDriver driver = Driver.getInstance().getBrowser(Driver.Browser.Firefox);

    public void goTo(String url)
    {
        driver.navigate().to(url);
    }

    public void close()
    {
        driver.close();
    }
}
