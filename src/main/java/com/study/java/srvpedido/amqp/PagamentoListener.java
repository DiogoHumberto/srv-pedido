package com.study.java.srvpedido.amqp;

import com.study.java.srvpedido.dto.PagamentoDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Log4j2
@Component
public class PagamentoListener {

    @RabbitListener(queues = "pagamento.concluido")
    public void recebeMessage(PagamentoDto pgto){
        log.info("<<--->>Pedido Rabbit {}", pgto);
    }

}
