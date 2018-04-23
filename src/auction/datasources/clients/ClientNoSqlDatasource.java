package auction.datasources.clients;

import auction.entities.Client;

import java.util.Map;

public class ClientNoSqlDatasource implements ClientDatasource {

    @Override
    public Map<String, Client> getClients() {
        return null;
    }

    @Override
    public Client getClient(String id) {
        return null;
    }
}
