package temp_page;

import org.openqa.selenium.By;
import selenium_methods.Webelement;

public class TempPage {

    //locators
    private By search = By.cssSelector("input.fast-search__input");

    //web elements
    Webelement page = new Webelement();
    Webelement button = new Webelement();

    public void navigateTo(String url)
    {
        page.goTo(url);
    }

    public void searchIn()
    {
        button.click(search);
    }

}
