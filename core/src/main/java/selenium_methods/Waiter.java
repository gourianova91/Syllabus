package selenium_methods;

import driver.DriverManager;
import org.openqa.selenium.*;
import config.DriverSettings;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Waiter {

    private static int DIVIDER = 1;

    WebElement WaitUntilClickable(By locator, int divider)
    {
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(),
                TimeUnit.SECONDS.toSeconds(DriverSettings.getInstance().timeout / divider));
        wait.pollingEvery(Duration.ofMillis(DriverSettings.getInstance().interval));
        wait.ignoring(TimeoutException.class);
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(StaleElementReferenceException.class);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    WebElement WaitUntilClickable(By locator)
    {
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(),
                TimeUnit.SECONDS.toSeconds(DriverSettings.getInstance().timeout / DIVIDER));
        wait.pollingEvery(Duration.ofMillis(DriverSettings.getInstance().interval));
        wait.ignoring(TimeoutException.class);
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(StaleElementReferenceException.class);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    WebElement WaitUntilClickable(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(),
                TimeUnit.SECONDS.toSeconds(DriverSettings.getInstance().timeout / DIVIDER));
        wait.pollingEvery(Duration.ofMillis(DriverSettings.getInstance().interval));
        wait.ignoring(TimeoutException.class);
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(StaleElementReferenceException.class);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    WebElement WaitUntilClickable(WebElement element, int divider)
    {
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(),
                TimeUnit.SECONDS.toSeconds(DriverSettings.getInstance().timeout / divider));
        wait.pollingEvery(Duration.ofMillis(DriverSettings.getInstance().interval));
        wait.ignoring(TimeoutException.class);
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(StaleElementReferenceException.class);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement WaitUntilExist(By locator, int divider)
    {
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(),
                TimeUnit.SECONDS.toSeconds(DriverSettings.getInstance().timeout / divider));
        wait.pollingEvery(Duration.ofMillis(DriverSettings.getInstance().interval));
        wait.ignoring(TimeoutException.class);
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(StaleElementReferenceException.class);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement WaitUntilExist(By locator)
    {
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(),
                TimeUnit.SECONDS.toSeconds(DriverSettings.getInstance().timeout / DIVIDER));
        wait.pollingEvery(Duration.ofMillis(DriverSettings.getInstance().interval));
        wait.ignoring(TimeoutException .class);
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(StaleElementReferenceException.class);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    WebElement WaitUntilExist(WebElement element)
    {
        try
        {
            if (element.isDisplayed())
                return element;
        }
        catch (NoSuchElementException | StaleElementReferenceException e)
        {
            return null;
        }
        return null;
    }

    public WebElement WaitUntilDisplayed(By locator)
    {
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(),
                TimeUnit.SECONDS.toSeconds(DriverSettings.getInstance().timeout / DIVIDER));
        wait.pollingEvery(Duration.ofMillis(DriverSettings.getInstance().interval));
        wait.ignoring(TimeoutException .class);
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(StaleElementReferenceException.class);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
