package common;

import java.util.HashMap;
import java.util.Map;

/**
 * ScenarioContext acts as a globally accessible, thread-safe singleton storage for sharing data between steps and pages.
 */
public class TestDataContext {
    private static final TestDataContext INSTANCE = new TestDataContext(); // Singleton Instance
    private final ThreadLocal<Map<String, Object>> scenarioData = ThreadLocal.withInitial(HashMap::new);

    /**
     * Private constructor to enforce Singleton pattern.
     */
    private TestDataContext() {}

    /**
     * Provides global access to the single instance of ScenarioContext.
     */
    public static TestDataContext getInstance() {
        return INSTANCE;
    }

    /**
     * Stores a value in the scenario context.
     */
    public void set(String key, Object value) {
        scenarioData.get().put(key, value);
    }

    /**
     * Retrieves a value from the scenario context.
     */
    public Object get(String key) {
        return scenarioData.get().get(key);
    }

    /**
     * Clears the context data at the end of the scenario.
     */
    public void clear() {
        scenarioData.remove();
    }
}

