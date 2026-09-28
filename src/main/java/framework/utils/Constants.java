package framework.utils;

public class Constants {

    public static final String BASE_URL          = ConfigReader.get("base.url");
    public static final String BROWSER           = ConfigReader.get("browser");
    public static final int WAIT_SECONDS = Integer.parseInt(ConfigReader.get("wait.seconds"));
    public static final boolean HEADLESS         = Boolean.parseBoolean(ConfigReader.get("headless"));
    public static final String EMAIL             = ConfigReader.get("email");
    public static final String PASSWORD             = ConfigReader.get("password");
}
