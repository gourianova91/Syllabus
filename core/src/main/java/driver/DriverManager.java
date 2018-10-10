package driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private final static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    private final static Object lock = new Object();
    private static WebDriver instance = null;

    public static synchronized WebDriver getWebDriver() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = webDriver.get();
                }
            }
        }
        return instance;
    }

    public static void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
    }

    public static void removeWebDriver()
    {
        webDriver.remove();
    }
}
