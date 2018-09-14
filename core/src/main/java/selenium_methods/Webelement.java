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
    private static int DIVIDER = 1;

    public WebElement WaitUntilClickable(By locator, int divider)
    {
        WebDriverWait wait = new WebDriverWait(Driver.getInstance().currentDriver,
                TimeUnit.SECONDS.toSeconds(DriverSettings.getInstance().timeout / divider));
        wait.pollingEvery(Duration.ofMillis(DriverSettings.getInstance().interval));
        wait.ignoring(WebDriverException.class);
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(StaleElementReferenceException.class);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement WaitUntilClickable(By locator)
    {
        WebDriverWait wait = new WebDriverWait(Driver.getInstance().currentDriver,
                TimeUnit.SECONDS.toSeconds(DriverSettings.getInstance().timeout / DIVIDER));
        wait.pollingEvery(Duration.ofMillis(DriverSettings.getInstance().interval));
        wait.ignoring(WebDriverException.class);
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(StaleElementReferenceException.class);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement WaitUntilExist(By locator, int divider)
    {
        WebDriverWait wait = new WebDriverWait(Driver.getInstance().currentDriver,
                TimeUnit.SECONDS.toSeconds(DriverSettings.getInstance().timeout / divider));
        wait.pollingEvery(Duration.ofMillis(DriverSettings.getInstance().interval));
        wait.ignoring(WebDriverException.class);
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(StaleElementReferenceException.class);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement WaitUntilExist(By locator)
    {
        WebDriverWait wait = new WebDriverWait(Driver.getInstance().currentDriver,
                TimeUnit.SECONDS.toSeconds(DriverSettings.getInstance().timeout / DIVIDER));
        wait.pollingEvery(Duration.ofMillis(DriverSettings.getInstance().interval));
        wait.ignoring(WebDriverException.class);
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(StaleElementReferenceException.class);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
