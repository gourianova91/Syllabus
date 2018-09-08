package config;

public class DriverSettings {

    //region Singleton driver initialization
    private static volatile DriverSettings instance;

    private DriverSettings() {}

    public static DriverSettings getInstance() {
        if (instance == null) {
            synchronized (DriverSettings.class) {
                if (instance == null) {
                    instance = new DriverSettings();
                }
            }
        }
        return instance;
    }
    //endregion

    public String browser = "Chrome";
}
