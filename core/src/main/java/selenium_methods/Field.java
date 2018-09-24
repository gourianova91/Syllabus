package selenium_methods;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Field extends Waiter {

    public void type(By locator, String value)
    {
        WaitUntilClickable(locator).clear();
        WaitUntilClickable(locator).sendKeys(value);
    }

    public void typeEnter(By locator, String value)
    {
        WaitUntilClickable(locator).clear();
        WaitUntilClickable(locator).sendKeys(value);
        WaitUntilClickable(locator).sendKeys(Keys.ENTER);
    }
}
