package selenium_methods;

import driver.Driver;

public class Navigate extends Webelement
{

    public void goTo(String url)
    {
        Driver.getInstance().currentDriver.navigate().to(url);
    }
}
