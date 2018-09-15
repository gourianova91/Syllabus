package driver;

import events.Events;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class DriverFactory {

    private static ChromeOptions ChromeBrowserOptions()
    {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        options.addArguments("disable-infobars");
        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--js-flags=--expose-gc");
        options.addArguments("--enable-precise-memory-info");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-default-apps");
        return options;
    }

    private static FirefoxOptions FirefoxBrowserOptions()
    {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe"); //location of FF exe
        return options;
    }

    public static WebDriver createBrowser(String browserName) {
        WebDriver currentDriver = null;
        if (browserName.contains("Chrome")) {
            currentDriver = new ChromeDriver(ChromeBrowserOptions());
        } else if (browserName.contains("Firefox")) {
            currentDriver = new FirefoxDriver(FirefoxBrowserOptions());
            currentDriver.manage().window().maximize();
        }
        if (currentDriver != null) {
            EventFiringWebDriver eDriver = new EventFiringWebDriver(currentDriver);
            Events events = new Events();
            eDriver.register(events);
            return eDriver;
        }
        return null;
    }
}
