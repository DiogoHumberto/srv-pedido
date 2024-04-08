package com.study.java.srvpedido.amqp;

import com.study.java.srvpedido.dto.PagamentoDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

import static com.study.java.srvpedido.utils.ConstantsUltils.RAABIT_FILA_PAGAMENTO_PEDIDO;

@Log4j2
@Component
public class PagamentoListener {

    @RabbitListener(queues = RAABIT_FILA_PAGAMENTO_PEDIDO)
    public void recebeMessage(PagamentoDto pgto){
        log.info("<<--->> Pedido exc Rabbit {}", pgto);
    }

}
