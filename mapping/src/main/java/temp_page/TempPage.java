package temp_page;

import org.openqa.selenium.By;
import selenium_methods.Button;
import selenium_methods.Navigate;

public class TempPage {

    //locators
    private By search = By.cssSelector("input.fast-search__input1");

    //web elements
    Navigate navigate = new Navigate();
    Button button = new Button();

    public void goTo(String url)
    {
        navigate.goTo(url);
    }

    public void searchIn()
    {
        button.click(search, 30);
    }

}
