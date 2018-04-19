package auction.core.disruptor.handlers;

import auction.entities.Item;
import auction.events.EventBase;
import com.lmax.disruptor.EventHandler;

import java.util.Map;

public class ParsingHandler implements EventHandler {

    private Map<String, Item> items;

    public ParsingHandler(Map<String, Item> items) {
        this.items = items;
    }

    @Override
    public void onEvent(Object event, long sequence, boolean endOfBatch) {
        EventBase b = (EventBase) event;
        String[] split = b.getRawMessage().split(";");

    }
}
