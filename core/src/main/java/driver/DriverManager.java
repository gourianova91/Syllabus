package driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private final static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static synchronized WebDriver getWebDriver() {
        return webDriver.get();
    }

    public static void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
    }

    public static void removeWebDriver()
    {
        webDriver.remove();
    }
}
