package com.study.java.srvpedido.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConstantsUltils implements Serializable {

    public static final String RAABIT_FILA_PAGAMENTO_ENTREGA = "pagamento.entrega";

    public static final String RAABIT_FILA_PAGAMENTO_PEDIDO = "pagamento.pedido";

    public static final String RAABIT_EX_PAGAMENTO = "pagamentos.ex";

    public static final String RAABIT_EX_DLX = "pagamentos.dlx";

    public static final String RAABIT_FILA_PAGAMENTO_PEDIDO_DLQ = "pagamento.pedido-dlq";
}
