package selenium_methods;

import driver.DriverManager;

public class Navigate extends Waiter
{

    public void goTo(String url)
    {
        DriverManager.getWebDriver().navigate().to(url);
    }
}
