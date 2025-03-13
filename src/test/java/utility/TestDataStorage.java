package utility;

import java.io.FileWriter;
import java.io.IOException;

public class TestDataStorage {

    private static final String FILE_PATH = "src/test/resources/generated_test_data.txt";

    public static void saveTestData(String username, String email) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            writer.write("Username: " + username + ", Email: " + email + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
