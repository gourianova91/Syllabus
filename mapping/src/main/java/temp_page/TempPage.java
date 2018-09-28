package temp_page;

import org.openqa.selenium.By;
import selenium_methods.Button;
import selenium_methods.Field;
import selenium_methods.Navigate;

public class TempPage {

    //locators
    private final static By WRONG_SEARCH = By.cssSelector("input.fast-search__input1");
    private final static By SEARCH = By.cssSelector("input.fast-search__input");

    //web elements
    private Navigate navigate = new Navigate();
    private Button button = new Button();
    private Field field = new Field();

    public void goTo(String url)
    {
        navigate.goTo(url);
    }

    public void searchIn()
    {
        button.click(WRONG_SEARCH, 30);
    }

    public void searchFor(String value)
    {
        field.typeEnter(SEARCH, value);
    }

}
