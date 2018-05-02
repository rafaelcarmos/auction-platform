package auction.datasources;

import auction.entities.Auction;
import auction.entities.Client;
import auction.entities.Item;
import org.bson.Document;

import java.util.List;
import java.util.Map;

public interface Datasource {

    Map<String, Client> getClients();

    Client getClient(String id);

    Map<String, Auction> getAuctions();

    Auction getAuction(String id);

    Map<String, Item> getItems();

    Item getItem(String id);

    String insertAuction(Auction auction);

    String inserClient(Client client);

    String insertItem(Item item);

    void insertRawMessage(Document message);

    void insertEvent(Document event);

    void insertEvents(List<Document> events);

    void insertError(Document error);

    void close();
}
