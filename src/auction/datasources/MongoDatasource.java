package auction.datasources;

import auction.entities.Auction;
import auction.entities.Client;
import auction.entities.Item;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import config.Config;
import org.bson.Document;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MongoDatasource implements Datasource {

    private static Datasource instance;
    private MongoClient client;
    private MongoDatabase db;
    private MongoCollection<Document> eventsCollection;
    private MongoCollection<Document> errorsCollection;
    private MongoCollection<Document> rawMessageCollection;
    private Map<String, Client> clientsMap;
    private Map<String, Auction> auctionsMap;
    private Map<String, Item> itemsMap;
    private int lastClient = 0;
    private int lastAuction = 0;
    private int lastItem = 0;

    public MongoDatasource() {
        String host = Config.getProperties().getProperty("mongodb-host");
        String database = Config.getProperties().getProperty("mongodb-database");
        client = new MongoClient(host);
        db = client.getDatabase(database);
        eventsCollection = db.getCollection("events");
        errorsCollection = db.getCollection("errors");
        rawMessageCollection = db.getCollection("messages");
        clientsMap = new HashMap<>();
        auctionsMap = new HashMap<>();
        itemsMap = new HashMap<>();
    }

    public static Datasource getInstance() {
        instance = instance == null ? new MongoDatasource() : instance;
        return instance;
    }

    @Override
    public Map<String, Client> getClients() {
        return clientsMap;
    }

    @Override
    public Client getClient(String id) {
        return clientsMap.get(id);
    }

    @Override
    public Map<String, Auction> getAuctions() {
        return auctionsMap;
    }

    @Override
    public Auction getAuction(String id) {
        return auctionsMap.get(id);
    }

    @Override
    public Map<String, Item> getItems() {
        return itemsMap;
    }

    @Override
    public Item getItem(String id) {
        return itemsMap.get(id);
    }

    @Override
    public String insertAuction(Auction auction) {
        String id = String.valueOf(lastAuction);
        auctionsMap.put(id, auction);
        lastAuction++;
        return id;
    }

    @Override
    public String inserClient(Client client) {
        String id = String.valueOf(lastClient);
        clientsMap.put(id, client);
        lastClient++;
        return id;
    }

    @Override
    public String insertItem(Item item) {
        String id = String.valueOf(lastItem);
        itemsMap.put(id, item);
        lastItem++;
        return id;
    }

    @Override
    public void insertRawMessage(Document message) {
        rawMessageCollection.insertOne(message);
    }

    @Override
    public void insertEvent(Document event) {
        eventsCollection.insertOne(event);
    }

    @Override
    public void insertEvents(List<Document> events) {
        eventsCollection.insertMany(events);
    }

    @Override
    public void insertError(Document error) {
        errorsCollection.insertOne(error);
    }

    @Override
    public void close() {
        client.close();
    }
}
