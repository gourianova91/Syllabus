package selenium_methods;

import config.DriverSettings;
import driver.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Element extends Waiter {

    private static int DIVIDER = 1;

    public String getText(By locator)
    {
        return WaitUntilExist(locator).getText();
    }

    public String getText(WebElement element)
    {
        return WaitUntilExist(element).getText();
    }

    public boolean isPresent(By locator, int divider)
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), TimeUnit.SECONDS.toSeconds(DriverSettings.getInstance().timeout / divider));
            wait.pollingEvery(Duration.ofMillis(DriverSettings.getInstance().interval));
            wait.ignoring(StaleElementReferenceException.class);
            wait.ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        }
        catch (NoSuchElementException | TimeoutException e)
        {
            return false;
        }
    }

    public boolean isPresent(By locator)
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), TimeUnit.SECONDS.toSeconds(DriverSettings.getInstance().timeout / DIVIDER));
            wait.pollingEvery(Duration.ofMillis(DriverSettings.getInstance().interval));
            wait.ignoring(StaleElementReferenceException.class);
            wait.ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        }
        catch (NoSuchElementException | TimeoutException e)
        {
            return false;
        }
    }

    public boolean isDisplayed(By locator, int divider)
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), TimeUnit.SECONDS.toSeconds(DriverSettings.getInstance().timeout / divider));
            wait.pollingEvery(Duration.ofMillis(DriverSettings.getInstance().interval));
            wait.ignoring(StaleElementReferenceException.class);
            wait.ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        }
        catch (NoSuchElementException | TimeoutException e)
        {
            return false;
        }
    }

    public boolean isDisplayed(By locator)
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), TimeUnit.SECONDS.toSeconds(DriverSettings.getInstance().timeout / DIVIDER));
            wait.pollingEvery(Duration.ofMillis(DriverSettings.getInstance().interval));
            wait.ignoring(StaleElementReferenceException.class);
            wait.ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        }
        catch (NoSuchElementException | TimeoutException e)
        {
            return false;
        }
    }

    public boolean isDisplayed(WebElement element)
    {
        try
        {
            return WaitUntilExist(element).isDisplayed();
        }
        catch (NoSuchElementException | TimeoutException e)
        {
            return false;
        }
    }

    public List<WebElement> getAllWebElements(By locator, int divider)
    {
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(),
                TimeUnit.SECONDS.toSeconds(DriverSettings.getInstance().timeout / divider));
        wait.pollingEvery(Duration.ofMillis(DriverSettings.getInstance().interval));
        wait.ignoring(TimeoutException.class);
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return DriverManager.getWebDriver().findElements(locator);
    }

    public List<WebElement> getAllWebElements(By locator)
    {
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(),
                TimeUnit.SECONDS.toSeconds(DriverSettings.getInstance().timeout / DIVIDER));
        wait.pollingEvery(Duration.ofMillis(DriverSettings.getInstance().interval));
        wait.ignoring(TimeoutException.class);
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return DriverManager.getWebDriver().findElements(locator);
    }
}
