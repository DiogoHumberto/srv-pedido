package com.study.java.srvpedido.amqp;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.study.java.srvpedido.utils.ConstantsUltils.*;

@Configuration
public class PedidoAMQPConfig {

    @Bean
    public Queue filaEntrega() {
        return QueueBuilder.nonDurable(RAABIT_FILA_PAGAMENTO_PEDIDO).build();
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return ExchangeBuilder
                .fanoutExchange(RAABIT_EX_PAGAMENTO)
                .build();
    }

    @Bean
    public Binding bindPagamentoPedido() {
        return BindingBuilder
                .bind(filaEntrega())
                .to(fanoutExchange());
    }

    @Bean
    public FanoutExchange deadLetterExchange() {
        return ExchangeBuilder
                .fanoutExchange(RAABIT_EX_DLX)
                .build();
    }

    @Bean
    public Queue filaDlqEntrega() {

        return QueueBuilder.nonDurable(RAABIT_FILA_PAGAMENTO_PEDIDO_DLQ).build();
    }

    //bing para fila deadLetter
    @Bean
    public Binding bindDlqPagamentoEntrega() {
        return BindingBuilder
                .bind(filaDlqEntrega())
                .to(deadLetterExchange());
    }

    @Bean
    public RabbitAdmin criaRabbitAdmin(ConnectionFactory conn) {
        return new RabbitAdmin(conn);
    }

    @Bean
    public ApplicationListener<ApplicationReadyEvent> inicializaAdmin(RabbitAdmin rabbitAdmin) {
        return event -> rabbitAdmin.initialize();
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter(){
        return  new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory,
                                         Jackson2JsonMessageConverter messageConverter){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return  rabbitTemplate;
    }

}
