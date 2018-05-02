package auction.core.handlers;

import auction.datasources.Datasource;
import auction.datasources.MongoDatasource;
import auction.entities.Auction;
import auction.events.AuctionEndEvent;
import auction.events.AuctionStartEvent;
import auction.events.BidEvent;
import auction.events.EventBase;
import com.lmax.disruptor.EventHandler;

public class ParseMessageHandler implements EventHandler {

    private Datasource datasource = MongoDatasource.getInstance();

    public ParseMessageHandler() {

    }

    @Override
    public void onEvent(Object event, long sequence, boolean endOfBatch) {

        EventBase base = (EventBase) event;
        String[] split = base.getRawMessage().split(";");
        base.setEventType(EventBase.EventType.valueOf(split[0]));

        switch (base.getEventType()) {

            case BID:
                BidEvent bid = new BidEvent();
                bid.setAuctionId(split[1]);
                bid.setBidderId(split[2]);
                bid.setAmount(Double.parseDouble(split[3]));
                base.setTarget(datasource.getAuction(bid.getAuctionId()));
                base.setEvent(bid);
                break;
            case AUCTION_START:
                AuctionStartEvent start = new AuctionStartEvent();
                start.setAuctioneerId(split[1]);
                start.setItemId(split[2]);
                start.setIncreaseFactor(Double.parseDouble(split[3]));
                start.setInitialPrice(Double.parseDouble(split[4]));
                start.setDateTime(base.getTimestamp());
                base.setTarget(new Auction());
                base.setEvent(start);
                break;
            case AUCTION_END:
                AuctionEndEvent end = new AuctionEndEvent();
                end.setAuctionId(split[1]);
                end.setDateTime(base.getTimestamp());
                base.setTarget(datasource.getAuction(end.getAuctionId()));
                base.setEvent(end);
                break;
        }

    }
}
