package auction.events;

import auction.entities.Bid;

public class BidEvent implements Event {

    private Bid bid;

    public BidEvent(Bid bid) {
        this.bid = bid;
    }

    public Bid getBid() {
        return bid;
    }

    public void setBid(Bid bid) {
        this.bid = bid;
    }
}
