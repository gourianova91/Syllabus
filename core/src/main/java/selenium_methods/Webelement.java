package selenium_methods;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import config.DriverSettings;

public class Webelement {

    WebDriver driver = Driver.getInstance().getBrowser(DriverSettings.getInstance().browser);

    public void goTo(String url)
    {
        driver.navigate().to(url);
    }

    public void close()
    {
        driver.close();
    }
}
