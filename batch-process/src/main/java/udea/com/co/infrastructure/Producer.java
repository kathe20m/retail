package udea.com.co.infrastructure;

import org.jboss.logging.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import udea.com.co.model.Client;
import udea.com.co.model.Refund;
import udea.com.co.model.Sale;

import java.util.concurrent.CompletableFuture;

@Component
public class Producer {

    private static final Logger LOG = Logger.getLogger(Producer.class);
    private static final String EXCHANGE_NAME = "exchange_retail";

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public Producer(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishAsyncClient(Client client) {
        CompletableFuture.runAsync(() -> rabbitTemplate.convertAndSend(EXCHANGE_NAME, "cliente", client));
        LOG.info("Client published: " + client.toString());
    }

    public void publishAsyncSale(Sale sale) {
        CompletableFuture.runAsync(() -> rabbitTemplate.convertAndSend(EXCHANGE_NAME, "venta", sale));
        LOG.info("Sale published: " + sale.toString());
    }

    public void publishAsyncRefund(Refund refund) {
        CompletableFuture.runAsync(() -> rabbitTemplate.convertAndSend(EXCHANGE_NAME, "devolucion", refund));
        LOG.info("Refund published: " + refund.toString());
    }
}
