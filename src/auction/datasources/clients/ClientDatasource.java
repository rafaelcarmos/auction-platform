package auction.datasources.clients;

import auction.entities.Client;

import java.util.Map;

public interface ClientDatasource {

    Map<String, Client> getClients();

    Client getClient(String id);
}
