package selenium_methods;

import driver.Driver;
import org.openqa.selenium.*;
import config.DriverSettings;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Webelement {

    WebDriver driver = Driver.getInstance().currentDriver;

    public WebElement WaitUntilClickable(By locator, int delimeter)
    {
        WebDriverWait wait = new WebDriverWait(Driver.getInstance().currentDriver,
                TimeUnit.SECONDS.toSeconds(DriverSettings.getInstance().timeout / delimeter));
        wait.pollingEvery(Duration.ofMillis(DriverSettings.getInstance().interval));
        wait.ignoring(WebDriverException.class);
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(StaleElementReferenceException.class);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement WaitUntilExist(By locator, int delimeter)
    {
        WebDriverWait wait = new WebDriverWait(Driver.getInstance().currentDriver, TimeUnit.SECONDS.toSeconds(DriverSettings.getInstance().timeout / delimeter));
        wait.pollingEvery(Duration.ofMillis(DriverSettings.getInstance().interval));
        wait.ignoring(WebDriverException.class);
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(StaleElementReferenceException.class);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
