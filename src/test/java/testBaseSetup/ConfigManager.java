package testBaseSetup;

public class ConfigManager {

    private ConfigManager(){

    }

    private static final String browser =  System.getProperty("browser","chrome");
    private static final boolean headLessMode = Boolean.parseBoolean(System.getProperty("isHeadLessMode","false"));

    public static String getBrowser(){
        return browser;
    }
    public static boolean getHeadLessMode(){
        return headLessMode;
    }
}
