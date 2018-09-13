package selenium_methods;

public class Navigate extends Webelement
{

    public void goTo(String url)
    {
        driver.navigate().to(url);
    }
}
