package selenium_methods;

import org.openqa.selenium.By;

public class Button extends Waiter {

    public void click(By locator)
    {
        WaitUntilClickable(locator).click();
    }

    public void click(By locator, int divider)
    {
        WaitUntilClickable(locator, divider).click();
    }
}
