package com.bidding.handlers;

import com.bidding.entity.Bid;
import com.lmax.disruptor.EventHandler;
import config.Config;

import java.io.Writer;

public class PersistingHandler implements EventHandler {
    private Writer writer;

    public PersistingHandler(Writer w) {
        String bidsFilePath = Config.getProperties().getProperty("bidsFile");
        writer = w;
    }

    @Override
    public void onEvent(Object event, long sequence, boolean endOfBatch) throws Exception {
        Bid b = (Bid) event;
        writer.write(b.getRawMessage() + "\n");
    }
}
