package auction.entities;

import java.time.LocalDateTime;

public class Auction {

    private String id;
    private String itemId;
    private String auctioneerId;
    private double increaseFactor;
    private double initialPrice;
    private String winningBidderId;
    private double winningBid = -1;
    private LocalDateTime start;
    private LocalDateTime end;
    private boolean isActive;

    public Auction() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public double getIncreaseFactor() {
        return increaseFactor;
    }

    public void setIncreaseFactor(double increaseFactor) {
        this.increaseFactor = increaseFactor;
    }

    public double getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(double initialPrice) {
        this.initialPrice = initialPrice;
    }

    public String getWinningBidderId() {
        return winningBidderId;
    }

    public void setWinningBidderId(String winningBidderId) {
        this.winningBidderId = winningBidderId;
    }

    public double getWinningBid() {
        return winningBid;
    }

    public void setWinningBid(double winningBid) {
        this.winningBid = winningBid;
    }

    public double getNextMinimumBid() {
        return winningBid != -1 ? winningBid * increaseFactor : initialPrice;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
