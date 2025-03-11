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
}
