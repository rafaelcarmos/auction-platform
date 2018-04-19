package com.bidding.entity.factory;

import com.bidding.entity.Item;
import com.lmax.disruptor.EventFactory;

public class ItemFactory implements EventFactory<Item> {
    @Override
    public Item newInstance() {
        return new Item();
    }
}
