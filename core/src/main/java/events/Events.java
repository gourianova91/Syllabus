package events;

import config.DriverSettings;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Events extends AbstractWebDriverEventListener
{
    private String JQUERY_WAIT = "if (typeof jQuery !== 'undefined'){return (jQuery.active == 0);} else {return true;}";
    private String ANGULAR_WAIT = "if (typeof angular !== 'undefined') {return (angular.element(document).injector().get('$http').pendingRequests.length === 0);} else {return true;}";
    private String DOCUMENT_READY = "return document.readyState == 'complete'";

    public void waitForAjax()
    {
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(),
                TimeUnit.SECONDS.toSeconds(DriverSettings.getInstance().ajaxWait));
        // - - - JQuery wait - - -
        wait.until( d -> ((JavascriptExecutor) d).executeScript(JQUERY_WAIT));
        // - - - Angular wait - - -
        wait.until( d -> ((JavascriptExecutor) d).executeScript(ANGULAR_WAIT));
    }

    public void waitForDocumentReady()
    {
        // - - - Document wait - - -
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(),
                TimeUnit.SECONDS.toSeconds(DriverSettings.getInstance().ajaxWait));
        wait.until( d -> ((JavascriptExecutor) d).executeScript(DOCUMENT_READY));
    }

    public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println("Before navigating to: '" + url + "'");
        waitForAjax();
        waitForDocumentReady();
    }

    public void afterNavigateTo(String url, WebDriver driver) {
        System.out.println("Navigated to: '" + url + "'");
        waitForAjax();
        waitForDocumentReady();
    }

    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        waitForAjax();
        waitForDocumentReady();
    }

    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        waitForAjax();
        waitForDocumentReady();
    }

    public void beforeClickOn(WebElement element, WebDriver driver) {
        waitForAjax();
        waitForDocumentReady();
    }

    public void afterClickOn(WebElement element, WebDriver driver) {
        waitForAjax();
        waitForDocumentReady();
    }

    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        waitForAjax();
        waitForDocumentReady();
    }

    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        waitForAjax();
        waitForDocumentReady();
    }

    public void beforeGetText(WebElement element, WebDriver driver) {
        waitForAjax();
        waitForDocumentReady();
    }

    public void afterGetText(WebElement element, WebDriver driver, String text) {
        waitForAjax();
        waitForDocumentReady();
    }

    public void onException(Throwable error, WebDriver driver) {
        System.out.println("Error occurred: " + error);
    }
}
