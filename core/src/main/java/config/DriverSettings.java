package config;

public class DriverSettings {

    //region Singleton driver initialization
    private final static ThreadLocal<DriverSettings> instance = ThreadLocal.withInitial( () -> new DriverSettings());

    private DriverSettings() {}

    private static DriverSettings myInstance = null;

    public static DriverSettings getInstance() {
        if (myInstance == null) {
            synchronized (DriverSettings.class) {
                if (myInstance == null) {
                    myInstance = instance.get();
                }
            }
        }
        return myInstance;
    }
    //endregion


    public int ajaxWait = 60;
    public int timeout = 40;
    public int interval = 50;
    public String browserName = "Chrome";
}
