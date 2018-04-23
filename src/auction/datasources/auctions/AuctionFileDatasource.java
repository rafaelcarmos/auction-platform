package auction.datasources.auctions;

import auction.entities.Auction;
import config.Config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class AuctionFileDatasource implements AuctionDatasource {

    private AuctionFileDatasource instance;
    private HashMap<String, Auction> auctions = new HashMap<>();

    private AuctionFileDatasource() {
        loadClientsFromFile();
    }

    private AuctionFileDatasource getInstance() {
        instance = instance == null ? new AuctionFileDatasource() : instance;
        return instance;
    }

    public Map<String, Auction> getAuctions() {
        return auctions;
    }

    public Auction getAuctions(String id) {
        return auctions.get(id);
    }

    private void loadClientsFromFile() {
        try {
            Properties p = Config.getProperties();
            File f = new File(p.getProperty("AuctionsFile"));
            BufferedReader r = new BufferedReader(new FileReader(f));

            String s;
            while ((s = r.readLine()) != null) {
//                String[] split = s.split(";");
//                Client c = new Client();
//                c.setClientId(split[0]);
//                c.setName(split[1]);
//                auctions.put(c.getClientId(), c);
            }
            r.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
