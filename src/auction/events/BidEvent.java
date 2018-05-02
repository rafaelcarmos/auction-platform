package auction.events;

import auction.entities.Auction;
import org.bson.Document;

public class BidEvent implements Event {

    private double amount = 0d;
    private String auctionId;
    private String bidderId;

    public BidEvent() {

    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(String auctionId) {
        this.auctionId = auctionId;
    }

    public String getBidderId() {
        return bidderId;
    }

    public void setBidderId(String bidderId) {
        this.bidderId = bidderId;
    }

    @Override
    public Document getDocument() {
        Document doc = new Document();
        doc.append("auction", auctionId);
        doc.append("bidder", bidderId);
        doc.append("amount", amount);
        return doc;
    }

    @Override
    public void applyTo(Object o) throws Exception {
        Auction auction = (Auction) o;

        if (!auction.isActive()) {
            throw new Exception("Auction " + auction.getId() + " is not active.");
        }

        if (amount >= auction.getNextMinimumBid()) {
            auction.setWinningBid(amount);
            auction.setWinningBidderId(bidderId);
        }
    }
}
