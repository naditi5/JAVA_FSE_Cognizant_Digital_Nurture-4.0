package LoggingExample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingDemo {
    private static final Logger logger = LoggerFactory.getLogger(LoggingDemo.class);

    public static void main(String[] args) {
        // Info level
        logger.info("Application started...");

        // Warning level
        logger.warn("Low disk space warning");

        // Error level
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            logger.error("An error occurred: Division by zero", e);
        }

        logger.info("Application ended.");
    }
}
