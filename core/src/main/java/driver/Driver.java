package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;

public class Driver {

    //region Singleton driver initialization
    private static volatile Driver instance;

    private Driver() {}

    public static Driver getInstance(String value) {
        if (instance == null) {
            synchronized (Driver.class) {
                if (instance == null) {
                    instance = new Driver();
                }
            }
        }
        return instance;
    }
    //endregion

    private static String ChromeDriverLocation = System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    private static String FirefoxDriverLocation = System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");

    private ChromeOptions ChromeBrowserOptions()
    {
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File(ChromeDriverLocation));
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

    private FirefoxOptions FirefoxBrowserOptions()
    {
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("c:/Program Files/Nightly/firefox.exe");
        options.addArguments("-console");
        options.addPreference("browser.cache.disk.enable", false);
        return options;
    }

    public WebDriver getBrowser(Browser browser)
    {
        WebDriver driver;
        switch(browser)
        {
            case Chrome:
                driver = new ChromeDriver(ChromeBrowserOptions());
                break;
            case Firefox:
                driver = new FirefoxDriver(FirefoxBrowserOptions());
                break;
            default:
                driver = new ChromeDriver(ChromeBrowserOptions());
                break;
        }
        return driver;
    }

    public enum Browser
    {
        Chrome,
        Firefox
    }
}
