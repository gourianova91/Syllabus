package driver;

import config.DriverSettings;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    private final static ThreadLocal<DriverManager> instance = new ThreadLocal<>();

    private DriverManager(){}

    private final static Object lock = new Object();
    private WebDriver driver = null;

    public static synchronized WebDriver getWebDriver() {
        return getInstance().getDriver();
    }

    private static synchronized DriverManager getInstance()
    {
        synchronized (lock) {
            if (instance.get() == null) {
                instance.set(new DriverManager());
            }
        }
        return instance.get();
    }

    public WebDriver getDriver()
    {
        if (driver == null)
        {
            driver = DriverFactory.createBrowser(DriverSettings.getInstance().browserName);
        }
        return driver;
    }

    public void destroyDriver()
    {
        if (driver != null)
        {
            driver.quit();
            driver = null;
        }
    }
}
