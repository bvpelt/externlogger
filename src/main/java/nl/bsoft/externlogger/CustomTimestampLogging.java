package nl.bsoft.externlogger;
import org.slf4j.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

public class CustomTimestampLogging {

    private static final Logger logger = LoggerFactory.getLogger(CustomTimestampLogging.class);

    public static void main(String[] args) {
        // Generate custom timestamp (example using current time)
        long customTimestamp = System.currentTimeMillis();
        LocalDateTime ts = LocalDateTime.of(2024, 01, 02, 10, 15, 20);
        MDC.put("customTimestamp", String.valueOf(ts));

        logger.info("This is my error message");

        try {
            // Simulate error scenario
            throw new RuntimeException("This is a simulated error!");
        } catch (Exception e) {
            logger.error("Error occurred at custom timestamp: {}", customTimestamp, e);
        } finally {
            MDC.remove("customTimestamp"); // Clean up MDC
        }
    }
}
