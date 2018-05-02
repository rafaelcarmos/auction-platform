package auction.events;

import auction.entities.Auction;
import org.bson.Document;

import java.time.LocalDateTime;

public class AuctionEndEvent implements Event {

    private String auctionId;
    private LocalDateTime dateTime;

    public AuctionEndEvent() {

    }

    public String getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(String auctionId) {
        this.auctionId = auctionId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public Document getDocument() {
        return new Document().append("auction-id", auctionId).append("timestamp", dateTime);
    }

    @Override
    public void applyTo(Object o) {
        Auction auction = (Auction) o;
        auction.setEnd(dateTime);
        auction.setActive(false);
    }
}
