package auction.datasources.auctions;

import auction.entities.Auction;

import java.util.Map;

public class AuctionNoSqlDatasource implements AuctionDatasource {

    @Override
    public Map<String, Auction> getAuctions() {
        return null;
    }

    @Override
    public Auction getAuctions(String id) {
        return null;
    }
}
