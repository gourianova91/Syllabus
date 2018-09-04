package driver;

public class Driver {

    //region Singleton driver initialization
    private static volatile Driver instance;

    private Driver() {}

    public static Driver getInstance(String value) {
        if (instance == null) {
            synchronized (Driver.class) {
                if (instance == null) {
                    instance = new Driver();
                }
            }
        }
        return instance;
    }
    //endregion
}
