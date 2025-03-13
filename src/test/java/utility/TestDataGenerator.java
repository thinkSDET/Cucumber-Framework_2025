package utility;

import java.util.Random;

public class TestDataGenerator {

    public static String generateRandomUsername() {
        return "User" + new Random().nextInt(100000); // Generates User43567
    }

    public static String generateRandomEmail() {
        return "test" + System.currentTimeMillis() + "@mail.com"; // test167839283@mail.com
    }
}
