package auction.clients;

import auction.entities.Client;
import config.Config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ClientDataService {

    private ClientDataService instance;
    private HashMap<String, Client> clients = new HashMap<>();

    private ClientDataService() {
        loadClientsFromFile();
    }

    private ClientDataService getInstance() {
        instance = instance == null ? new ClientDataService() : instance;
        return instance;
    }

    public Map<String, Client> getClients() {
        return clients;
    }

    public Client getClient(String id) {
        return clients.get(id);
    }

    private void loadClientsFromFile() {
        try {
            Properties p = Config.getProperties();
            File f = new File(p.getProperty("ClientsFile"));
            BufferedReader r = new BufferedReader(new FileReader(f));

            String s;
            while ((s = r.readLine()) != null) {
                String[] split = s.split(";");
                Client c = new Client();
                c.setClientId(split[0]);
                c.setName(split[1]);
                clients.put(c.getClientId(), c);
            }
            r.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
