package selenium_methods;

import org.openqa.selenium.By;

public class Button extends Webelement {

    public void click(By locator, int delimeter)
    {
        WaitUntilClickable(locator, delimeter).click();
    }
}
