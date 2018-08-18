package udea.com.co.infrastructure;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConf {

    /**
    * Configuracion de la conexion al host donde se encuentra configurado el exchange y las colas a utilizar.
    */
    @Bean
    public ConnectionFactory connectionFactory(){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("lion.rmq.cloudamqp.com");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("wctjxpeo");
        connectionFactory.setUsername("wctjxpeo");
        connectionFactory.setPassword("7rCYi85hLoCnWx_QppzoCh5MR-A1b0rt");
        connectionFactory.setChannelCheckoutTimeout(1000);
        connectionFactory.setRequestedHeartBeat(300);

        return connectionFactory;
    }

    /**
     * Metodo encargado de crear un template custom, el cual transforma la información en el objeto indicado, en este caso
     * el mensaje entrante en el objecto Cliente mediante el producerJackson2MessageConverter.
     */
    @Bean
    public RabbitTemplate rabbitTemplate() {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }

    /**
     * Bean encargado de convertir el mensaje a JSON.
     */
    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
