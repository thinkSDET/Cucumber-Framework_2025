package utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class LoggerUtil {

    private static final Logger logger = LogManager.getLogger();
    private static final String TAG_INFO = "[INFO]: ";
    private static final String TAG_WARNING = "[WARNING]: ";
    private static final String TAG_ERROR = "[ERROR]: ";

    public static void info(Object message) {
        logger.info(TAG_INFO + "{}{}", getLogPrefix(), message);
    }

    public static void warn(Object message) {
        logger.warn(TAG_WARNING + "{}{}", getLogPrefix(), message);
    }

    public static void error(Object message, Throwable throwable) {
        logger.error(TAG_ERROR + "{}{}", getLogPrefix(), message, throwable);
    }

    private static String getLogPrefix() {
        StackTraceElement stackTrace = Thread.currentThread().getStackTrace()[3];
        String fullClassName = stackTrace.getClassName();
        String simpleClassName = fullClassName.substring(fullClassName.lastIndexOf(".") + 1); // Extract class name without package
        String methodName = stackTrace.getMethodName();
        return "[" + simpleClassName + "." + methodName + "] - ";
    }
    /**
     * I want to create a log file like this :
     *
     *   2025-03-10 19:01:14 [INFO]: ============================================================================
     *   2025-03-10 19:01:14 [INFO]: Starting Test [Add one quantity from Store]
     *   2025-03-10 19:01:14 [INFO]: Feature Name [Add to cart]
     *   2025-03-10 19:01:14 [INFO]: ============================================================================
     *   2025-03-10 19:01:14 [INFO]: --> Running Step: Launch the application with valid credentials
     *    2025-03-10 19:01:14 [INFO]: - Initializing the browser :'chrome'
     *
     *    and so on
     *
     *    [Add one quantity from Store]  -> dynamic
     *    [Add to cart] -> dynamic
     *
     * Feature: Add to cart
     *   @Smoke
     *   Scenario: Add one quantity from Store
     *     * Launch the application with valid credentials
     *     * Navigate to the store page
     *     * Add the product from the store page
     *       | Basic Blue Jeans |
     *     * Navigate to cart page
     *     * Verify that user can find the added product in cart page
     *       | Product         | Quantity |
     *       | Basic Blue Jeans | 1        |
     */
}
