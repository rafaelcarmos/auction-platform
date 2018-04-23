package auction.events;

import auction.entities.Auction;

public class AuctionAddedEvent implements Event {

    private Auction auction;

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }
}
