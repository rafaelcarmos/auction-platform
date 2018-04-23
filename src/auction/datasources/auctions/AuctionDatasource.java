package auction.datasources.auctions;

import auction.entities.Auction;

import java.util.Map;

public interface AuctionDatasource {

    Map<String, Auction> getAuctions();

    Auction getAuctions(String id);
}
