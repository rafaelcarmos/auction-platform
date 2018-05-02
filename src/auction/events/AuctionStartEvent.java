package auction.events;

import auction.datasources.MongoDatasource;
import auction.entities.Auction;
import org.bson.Document;

import java.time.LocalDateTime;

public class AuctionStartEvent implements Event {

    private LocalDateTime dateTime;
    private String itemId;
    private String auctioneerId;
    private double initialPrice;
    private double increaseFactor;

    public AuctionStartEvent() {

    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getAuctioneerId() {
        return auctioneerId;
    }

    public void setAuctioneerId(String auctioneerId) {
        this.auctioneerId = auctioneerId;
    }

    public double getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(double initialPrice) {
        this.initialPrice = initialPrice;
    }

    public double getIncreaseFactor() {
        return increaseFactor;
    }

    public void setIncreaseFactor(double increaseFactor) {
        this.increaseFactor = increaseFactor;
    }

    @Override
    public Document getDocument() {
        return null;
    }

    @Override
    public void applyTo(Object o) {
        Auction auction = (Auction) o;
        auction.setStart(dateTime);
        auction.setAuctioneerId(auctioneerId);
        auction.setItemId(itemId);
        auction.setInitialPrice(initialPrice);
        auction.setIncreaseFactor(increaseFactor);
        auction.setActive(true);
        MongoDatasource.getInstance().insertAuction(auction);
    }
}
