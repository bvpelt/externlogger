package nl.bsoft.externlogger.controller;
import nl.bsoft.externlogger.domain.ClientMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private static final Logger logger = LogManager.getLogger(MessageController.class);

    @PostMapping
    public void receiveMessage(@RequestBody ClientMessage clientMessage) {
        String customTimestamp = clientMessage.getTimestamp();
        String logMessage = String.format("%s %s : %s",
                customTimestamp, MessageController.class.getName(), clientMessage.getMessage());

        logger.info(logMessage);
    }
}
