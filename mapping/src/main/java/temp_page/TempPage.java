package temp_page;

import org.openqa.selenium.By;
import selenium_methods.Button;
import selenium_methods.Field;
import selenium_methods.Navigate;

public class TempPage {

    //locators
    private By wrongSearch = By.cssSelector("input.fast-search__input1");
    private By search = By.cssSelector("input.fast-search__input");

    //web elements
    Navigate navigate = new Navigate();
    Button button = new Button();
    Field field = new Field();

    public void goTo(String url)
    {
        navigate.goTo(url);
    }

    public void searchIn()
    {
        button.click(wrongSearch, 30);
    }

    public void searchFor(String value)
    {
        field.typeEnter(search, value);
    }

}
