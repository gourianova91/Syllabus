package driver;

import config.DriverSettings;
import events.Events;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Driver {

    //region Singleton driver initialization
    private static volatile Driver instance;

    public WebDriver currentDriver;

    private Driver() {}

    public static Driver getInstance() {
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

    private ChromeOptions ChromeBrowserOptions()
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

    private FirefoxOptions FirefoxBrowserOptions()
    {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe"); //location of FF exe
        return options;
    }

    public WebDriver getDriver()
    {
        if (instance == null)
        {
            return getBrowser(DriverSettings.getInstance().browser);
        }
        return currentDriver;
    }

    public WebDriver getBrowser(String browser) {
        currentDriver = null;
        if (browser.equals("Chrome")) {
            currentDriver = new ChromeDriver(ChromeBrowserOptions());
        } else if (browser.equals("Firefox")) {
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

    public void destroyDriver()
    {
        if (instance != null)
        {
            currentDriver.close();
            currentDriver.quit();
            instance = null;
        }
    }
}
