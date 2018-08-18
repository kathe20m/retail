package udea.com.co.util;

import org.apache.commons.lang.StringUtils;
import udea.com.co.model.Client;

import java.util.ArrayList;
import java.util.List;

public class DataBaseUtil {

    private static List<Client> dataBaseClient = new ArrayList<>();

    public static void saveClient(Client client) {
        dataBaseClient.add(client);
    }

    public static Client getClient(String clientIdentification) {
        Client clientToRetrieve = new Client();

        for (Client client : dataBaseClient) {
            if (StringUtils.isNotEmpty(clientIdentification) && client.getClientId().equals(clientIdentification)) {
                clientToRetrieve = client;
            }
        }
        return clientToRetrieve;
    }
}
