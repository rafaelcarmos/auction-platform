package auction.entities;

public class Bid {

    private double bidAmount = 0d;
    private Auction auction;
    private Client bidder;

    public Bid() {

    }

    public double getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(double bidAmount) {
        this.bidAmount = bidAmount;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public Client getBidder() {
        return bidder;
    }

    public void setBidder(Client bidder) {
        this.bidder = bidder;
    }
}
