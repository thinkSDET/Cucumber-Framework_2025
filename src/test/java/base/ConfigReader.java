package base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
            try (FileInputStream file = new FileInputStream("src\\test\\resources\\properties")) {
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
        return getProperty("url");
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
