package temp_page;

import selenium_methods.Webelement;

public class TempPage {

    Webelement page = new Webelement();

    public void navigateTo(String url)
    {
        page.goTo(url);
    }

    public void closeBrowser()
    {
        page.close();
    }
}
