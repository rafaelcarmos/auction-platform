package auction.events;

import java.time.LocalDateTime;

public class EventBase {

    private String rawMessage;
    private LocalDateTime timestamp;
    private EventType eventType;

    public EventBase() {

    }

    public String getRawMessage() {
        return rawMessage;
    }

    public void setRawMessage(String rawMessage) {
        this.rawMessage = rawMessage;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public enum EventType {
        BID,
        NEW_AUCTION,
        END_AUCTION
    }
}
