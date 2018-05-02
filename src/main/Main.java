package main;

import auction.core.processors.DisruptorEventProcessor;
import auction.core.processors.EventProcessor;

public class Main {
    public static void main(String args[]) {
        EventProcessor processor = new DisruptorEventProcessor();

        processor.processEvent("AUCTION_START;123;123;1.1;1000");

        for (int i = 0; i < 1000; i++) {
            double amount = 900 + i;
            processor.processEvent("BID;0;152;" + Double.toString(amount));
        }

        processor.processEvent("AUCTION_END;0");

        for (int i = 0; i < 1000; i++) {
            double amount = 900 + i;
            processor.processEvent("BID;0;152;" + Double.toString(amount));
        }
    }
}
