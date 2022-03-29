package com.wit.restModule.connections;

import com.wit.libDataDtoChangelle.consts.RabbitMQConsts;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RabbitMQConnection {

    private static final String NOME_EXCHANGE = "amq.direct";

    @Autowired
    private AmqpAdmin amqpAdmin;

    public RabbitMQConnection(AmqpAdmin amqpAdmin) {
        this.amqpAdmin = amqpAdmin;
    }

    @PostConstruct
    private void init() {
        DirectExchange directExchange = this.exchange();
        this.amqpAdmin.declareExchange(directExchange);

        Queue queue1 = this.getQueue(RabbitMQConsts.QUEUE_CALCULATE);
        Binding connect1 = this.connectQueueExchange(queue1, directExchange);
        this.declareQueue(queue1, connect1);

        Queue queue2 = this.getQueue(RabbitMQConsts.QUEUE_RESPONSE);
        Binding connect2 = this.connectQueueExchange(queue2, directExchange);
        this.declareQueue(queue2, connect2);
    }

    private void declareQueue(Queue queue, Binding binding) {
        this.amqpAdmin.declareQueue(queue);
        this.amqpAdmin.declareBinding(binding);
    }

    private Queue getQueue(String queueName) {
        return new Queue(queueName, true, false, false);
    }

    private DirectExchange exchange() {
        return new DirectExchange(NOME_EXCHANGE);
    }

    private Binding connectQueueExchange(Queue fila, DirectExchange troca) {
        return new Binding(
                fila.getName(),
                Binding.DestinationType.QUEUE,
                troca.getName(),
                fila.getName(),
                null
        );
    }

}
