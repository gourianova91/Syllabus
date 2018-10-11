package selenium_methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Button extends Waiter {

    public void click(By locator)
    {
        WaitUntilClickable(locator).click();
    }

    public void click(WebElement element)
    {
        WaitUntilClickable(element).click();
    }

    public void click(By locator, int divider)
    {
        WaitUntilClickable(locator, divider).click();
    }

    public void click(WebElement element, int divider)
    {
        WaitUntilClickable(element, divider).click();
    }
}
