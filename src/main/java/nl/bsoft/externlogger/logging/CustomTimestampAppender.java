package nl.bsoft.externlogger.logging;

import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.layout.PatternLayout;

import java.io.Serializable;
import java.util.Date;

@Plugin(name = "CustomTimestampAppender", category = "Core", elementType = "appender", printObject = true)
public class CustomTimestampAppender extends AbstractAppender {

    protected CustomTimestampAppender(String name, Layout<? extends Serializable> layout) {
        super(name, null, layout, false, null);
    }

    @PluginFactory
    public static CustomTimestampAppender createAppender(
            @PluginAttribute("name") String name) {
        Layout<? extends Serializable> layout = PatternLayout.createDefaultLayout();
        return new CustomTimestampAppender(name, layout);
    }

    @Override
    public void append(LogEvent event) {
        String message = event.getMessage().getFormattedMessage();
        // Extract custom timestamp from the message or use some custom logic
        String customTimestamp = extractTimestampFromMessage(message);

        String logMessage = String.format("%s [%s] %s", customTimestamp, event.getThreadName(), message);
        System.out.println(logMessage); // Replace this with actual file writing logic
    }

    private String extractTimestampFromMessage(String message) {
        // Custom logic to extract timestamp from message
        // Assuming the timestamp is at the start of the message
        return new Date().toString(); // Replace this with actual extraction logic
    }
}
