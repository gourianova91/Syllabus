package selenium_methods;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import config.DriverSettings;

public class Webelement {

    WebDriver driver = Driver.getInstance().currentDriver;

    public void goTo(String url)
    {
        driver.navigate().to(url);
    }

    public void click(By locator)
    {
        driver.findElement(locator);
    }
}
