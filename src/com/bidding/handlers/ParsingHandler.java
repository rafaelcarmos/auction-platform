package com.bidding.handlers;

import com.bidding.entity.Bid;
import com.bidding.entity.Item;
import com.lmax.disruptor.EventHandler;

import java.util.Map;

public class ParsingHandler implements EventHandler {

    private Map<String, Item> items;

    public ParsingHandler(Map<String, Item> items) {
        this.items = items;
    }

    @Override
    public void onEvent(Object event, long sequence, boolean endOfBatch) {
        Bid b = (Bid) event;
        String[] split = b.getRawMessage().split(";");
        b.setBidder(split[0]);
        b.setItem(items.get(split[1]));
        b.setOffer(Double.parseDouble(split[2]));
    }
}
