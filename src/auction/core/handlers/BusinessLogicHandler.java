package auction.core.handlers;

import auction.entities.Bid;
import auction.entities.Item;
import com.lmax.disruptor.EventHandler;

import java.util.HashMap;
import java.util.Map;

public class BusinessLogicHandler implements EventHandler {

    private Map<Item, Bid> highestBids = new HashMap<>();

    public BusinessLogicHandler() {
    }

    @Override
    public void onEvent(Object event, long sequence, boolean endOfBatch) {
    }
}
