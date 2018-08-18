package udea.com.co.service;

import org.springframework.stereotype.Component;
import udea.com.co.model.Client;
import udea.com.co.util.DataBaseUtil;

@Component
public class ClientService {

    public Client getClient(String clientIdentification) {
        return DataBaseUtil.getClient(clientIdentification);
    }
}
