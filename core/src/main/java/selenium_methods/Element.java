package selenium_methods;

import org.openqa.selenium.By;

public class Element extends Webelement {

    public String getText(By locator, int delimeter)
    {
        return WaitUntilExist(locator, delimeter).getText();
    }
}
