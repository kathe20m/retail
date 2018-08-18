package udea.com.co.infrastructure;

import org.jboss.logging.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import udea.com.co.model.Client;
import udea.com.co.util.DataBaseUtil;

@Component
public class Consumer {

    private static final Logger LOG = Logger.getLogger(Consumer.class);

    @RabbitListener(queues = "cliente_procesado")
    public void getClientFromQueue(final Client client) {

        LOG.info("Client received: " + client.toString());
        DataBaseUtil.saveClient(client);
    }
}
