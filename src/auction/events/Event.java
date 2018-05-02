package auction.events;

import org.bson.Document;

public interface Event {
    Document getDocument();

    void applyTo(Object o) throws Exception;
}
