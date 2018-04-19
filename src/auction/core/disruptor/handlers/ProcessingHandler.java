package auction.core.disruptor.handlers;

import auction.entities.Bid;
import auction.entities.Item;
import com.lmax.disruptor.EventHandler;

import java.util.HashMap;
import java.util.Map;

public class ProcessingHandler implements EventHandler {

    private Map<Item, Bid> highestBids = new HashMap<>();

    public ProcessingHandler() {
    }

    @Override
    public void onEvent(Object event, long sequence, boolean endOfBatch) {
    }
}
