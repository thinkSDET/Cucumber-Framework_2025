package testBaseSetup.utils;

import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.FileAppender;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.apache.logging.log4j.core.layout.PatternLayout;

import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerUtil {

    private static final ThreadLocal<Logger> threadLocalLogger = new ThreadLocal<>();
    private static final String LOG_DIRECTORY = "target/logs/";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");

    /**
     * Initializes a thread-local logger for a specific scenario.
     *
     * @param scenario The Cucumber scenario object.
     */
    public static void initializeLogger(Scenario scenario) {
        String scenarioName = scenario.getName();
        String featureName = getFeatureName(scenario);

        // Create a unique log directory per date
        String dateFolder = LocalDateTime.now().format(DATE_FORMATTER);
        String logDirectory = Paths.get(LOG_DIRECTORY, dateFolder).toString();
        createDirectory(logDirectory);

        // Generate a unique log file per scenario
        String logFileName = LocalDateTime.now().format(TIME_FORMATTER) + "_" + featureName + "_" + scenarioName + ".log";
        String logFilePath = Paths.get(logDirectory, logFileName).toString();

        // Configure a thread-specific logger
        LoggerContext context = (LoggerContext) LogManager.getContext(false);
        Configuration config = context.getConfiguration();

        PatternLayout layout = PatternLayout.newBuilder()
                .withPattern("%d{yyyy-MM-dd HH:mm:ss} [%level]: %msg%n")
                .build();

        // Create a File Appender specific to this scenario
        FileAppender fileAppender = FileAppender.newBuilder()
                .setName("ScenarioFileAppender-" + scenarioName)
                .withFileName(logFilePath)
                .setLayout(layout)
                .build();
        fileAppender.start();

        // Create a Console Appender
        ConsoleAppender consoleAppender = ConsoleAppender.newBuilder()
                .setName("ConsoleAppender-" + scenarioName)
                .setLayout(layout)
                .build();
        consoleAppender.start();

        // Set up a logger for this scenario
        LoggerConfig loggerConfig = new LoggerConfig(scenarioName, org.apache.logging.log4j.Level.INFO, false);
        loggerConfig.addAppender(fileAppender, null, null);
        loggerConfig.addAppender(consoleAppender, null, null);

        config.addLogger(scenarioName, loggerConfig);
        context.updateLoggers();

        // Assign a separate logger for each scenario thread
        threadLocalLogger.set(LogManager.getLogger(scenarioName));

        // Log scenario start details
        logScenarioStart(scenarioName, featureName);
    }

    private static void logScenarioStart(String scenarioName, String featureName) {
        info("============================================================================");
        info("Starting Test [" + scenarioName + "]");
        info("Feature Name [" + featureName + "]");
        info("============================================================================");
    }

    /**
     * Logs an info message.
     *
     * @param message The message to log.
     */
    public static void info(String message) {
        Logger logger = threadLocalLogger.get();
        if (logger != null) {
            logger.info(message);
        }
    }

    /**
     * Logs an error message.
     *
     * @param message   The message to log.
     * @param throwable The exception or error to log.
     */
    public static void error(String message, Throwable throwable) {
        Logger logger = threadLocalLogger.get();
        if (logger != null) {
            logger.error(message, throwable);
        }
    }

    /**
     * Extracts the feature name from the scenario URI.
     *
     * @param scenario The Cucumber scenario object.
     * @return The feature name.
     */
    public static String getFeatureName(Scenario scenario) {
        String uri = scenario.getUri().toString();
        String[] parts = uri.split("/");
        String featureFile = parts[parts.length - 1]; // Get the last part of the URI
        return featureFile.replace(".feature", "").replace("_", " "); // Remove ".feature" and replace underscores with spaces
    }

    /**
     * Creates a directory if it doesn't exist.
     *
     * @param directoryPath The path of the directory to create.
     */
    private static void createDirectory(String directoryPath) {
        java.io.File directory = new java.io.File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }
}
