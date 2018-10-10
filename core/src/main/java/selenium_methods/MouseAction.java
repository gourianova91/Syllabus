package selenium_methods;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class MouseAction extends Waiter{

    Element element;

    public MouseAction()
    {
        element = new Element();
    }

    public void moveTo(By locator)
    {
        Actions action = new Actions(DriverManager.getWebDriver());
        action.moveToElement(WaitUntilExist(locator)).perform();
    }

    public void moveToAndClick(By locator)
    {
        Actions action = new Actions(DriverManager.getWebDriver());
        action.moveToElement(WaitUntilClickable(locator)).click().perform();
    }
}
