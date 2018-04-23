package auction.core.handlers;

import auction.entities.Bid;
import auction.events.EventBase;
import com.lmax.disruptor.EventHandler;

import java.time.LocalDateTime;

public class ParsingHandler implements EventHandler {

    public ParsingHandler() {

    }

    @Override
    public void onEvent(Object event, long sequence, boolean endOfBatch) {

        EventBase e = (EventBase) event;
        String[] split = e.getRawMessage().split(";");
        e.setEventType(EventBase.EventType.valueOf(split[0]));
        e.setTimestamp(LocalDateTime.now());

        switch (e.getEventType()) {
            case BID:
                Bid b = new Bid();
                //b.setAuction();
                break;
            case NEW_AUCTION:
                break;
            case END_AUCTION:
                break;
        }
    }
}
