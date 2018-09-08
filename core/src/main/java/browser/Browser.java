package browser;

import config.DriverSettings;

public class Browser {

    private String _browserName;
    private String _defaultBrowser;

    public Browser(String name)
    {
        _browserName = name;
        _defaultBrowser = DriverSettings.getInstance().browser;
    }
}
