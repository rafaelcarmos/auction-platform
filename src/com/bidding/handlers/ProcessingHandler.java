package com.bidding.handlers;

import com.bidding.entity.Bid;
import com.bidding.entity.Item;
import com.lmax.disruptor.EventHandler;

import java.util.HashMap;
import java.util.Map;

public class ProcessingHandler implements EventHandler {

    private Map<Item, Bid> highestBids = new HashMap<>();

    public ProcessingHandler() {
    }

    @Override
    public void onEvent(Object event, long sequence, boolean endOfBatch) {
        Bid b = (Bid) event;

        //if there is a highest offer
        if (highestBids.containsKey(b.getItem())) {
            Bid highestBid = highestBids.get(b.getItem());
            if (b.getOffer() > highestBid.getOffer()) {
                //if its higher, becomes the highest offer
                highestBids.replace(b.getItem(), b);
            }
        } else {
            //if there is no offer, current offer is the highest
            highestBids.put(b.getItem(), b);
        }
    }
}
