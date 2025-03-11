package testBaseSetup;
import testBaseSetup.utils.LoggerUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class ConfigReader {

    private static final Properties properties = new Properties();

    /**
     * The use of a static block in the ConfigReader class is a deliberate design choice to ensure that the
     * configuration properties are loaded only once when the class is first loaded into memory.
     */

    static {
        synchronized (ConfigReader.class) {  // Ensures only one thread loads the properties
            try (FileInputStream file = new FileInputStream("src\\test\\resources\\properties\\config.properties")) {
                properties.load(file);
            } catch (IOException e) {
                throw new RuntimeException("Failed to load configuration file: " + e.getMessage());
            }
        }
    }

    private static String getProperty(String key) {
        return properties.getProperty(key);  // Reading is thread-safe
    }

    public static String getBaseUrl() {
        String env = System.getProperty("ENV"); // Read from System Properties first
        if (env == null || env.isEmpty()) {
            env = getProperty("ENV"); // Fallback to config.properties if not set
        }

        if (env == null || env.isEmpty()) {
            LoggerUtil.error("ENV property is missing. Please provide a valid environment.");
        }

        String baseUrl = "";
        switch (env.toLowerCase()) {
            case "qa":
                baseUrl = getProperty("qa_env_url");
                LoggerUtil.info("Launched the QA URL: " + baseUrl);
                break;
            case "preprod":
                baseUrl = getProperty("preprod_env_url");
                LoggerUtil.info("Launched the PREPROD URL: " + baseUrl);
                break;
            case "prod":
                baseUrl = getProperty("prod_env_url");
                LoggerUtil.info("Launched the PROD URL: " + baseUrl);
                break;
            default:
                LoggerUtil.error("Invalid ENV value provided: [" + env + "]");
        }
        return baseUrl;
    }

    public static String getImplicitWait() {
        return getProperty("implicitWait");
    }
    public static String getUserName(){
        return getProperty("userName");
    }
    public static String getPassword(){
        return getProperty("password");
    }
}
