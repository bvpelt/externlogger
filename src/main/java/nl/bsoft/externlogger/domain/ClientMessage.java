package nl.bsoft.externlogger.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class ClientMessage {
    private String timestamp;
    private String message;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientMessage that = (ClientMessage) o;
        return Objects.equals(timestamp, that.timestamp) && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, message);
    }

    @Override
    public String toString() {
        return "ClientMessage{" +
                "timestamp='" + timestamp + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
