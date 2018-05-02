package auction.events;

import org.bson.Document;

import java.time.LocalDateTime;

public class EventBase {

    private Object target;

    private String rawMessage;
    private LocalDateTime timestamp;
    private EventType eventType;
    private Event event;

    public Object getTarget() {
        return target;
    }

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

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Document getDocument() {
        Document doc = new Document();
        doc.append("type", eventType.toString());
        doc.append("timestamp", timestamp.toString());
        doc.append("event", event.getDocument());
        return doc;
    }

    public enum EventType {
        BID,
        AUCTION_START,
        AUCTION_END
    }
}
