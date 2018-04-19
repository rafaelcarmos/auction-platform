package com.bidding.entity.factory;

import com.bidding.entity.Bid;
import com.lmax.disruptor.EventFactory;

public class BidFactory implements EventFactory<Bid> {

    @Override
    public Bid newInstance() {
        return new Bid();
    }
}
