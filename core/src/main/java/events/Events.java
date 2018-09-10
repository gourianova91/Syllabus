package events;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import selenium_methods.Webelement;

public class Events extends AbstractWebDriverEventListener
{
    public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println("Before navigating to: '" + url + "'");
    }

    public void afterNavigateTo(String url, WebDriver driver) {
        System.out.println("Navigated to:'" + url + "'");
    }

    public void beforeClickOn(Webelement element, WebDriver driver) {
        System.out.println("Trying to click on: " + element.toString());
    }

    public void afterClickOn(Webelement element, WebDriver driver) {
        System.out.println("Clicked on: " + element.toString());
    }

    public void onException(Throwable error, WebDriver driver) {
        System.out.println("Error occurred: " + error);
    }
}
