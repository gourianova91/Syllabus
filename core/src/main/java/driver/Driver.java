package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Driver {

    //region Singleton driver initialization
    private static volatile Driver instance;

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
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
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
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe"); //location of FF exe
        return options;
    }

    public WebDriver getBrowser(String browser) {
        WebDriver driver = null;
        if (browser.equals("Chrome")) {
            driver = new ChromeDriver(ChromeBrowserOptions());
        } else if (browser.equals("Firefox")) {
            driver = new FirefoxDriver(FirefoxBrowserOptions());
            driver.manage().window().maximize();
        }
        return driver;
    }
}
