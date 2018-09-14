package selenium_methods;

import org.openqa.selenium.By;

public class Element extends Webelement {

    public String getText(By locator)
    {
        return WaitUntilExist(locator).getText();
    }
}
