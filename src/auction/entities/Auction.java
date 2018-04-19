package auction.entities;

import java.time.LocalDateTime;

public class Auction {

    private Item auctionedItem;
    private Client auctioneer;
    private LocalDateTime dateStart;
    private LocalDateTime dateEnd;
    private LocalDateTime timestamp;

    public Auction() {

    }

    public Item getAuctionedItem() {
        return auctionedItem;
    }

    public void setAuctionedItem(Item auctionedItem) {
        this.auctionedItem = auctionedItem;
    }

    public Client getAuctioneer() {
        return auctioneer;
    }

    public void setAuctioneer(Client auctioneer) {
        this.auctioneer = auctioneer;
    }

    public LocalDateTime getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDateTime dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDateTime getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDateTime dateEnd) {
        this.dateEnd = dateEnd;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
