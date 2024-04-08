package com.study.java.srvpedido.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PagamentoDto (@JsonAlias("numero") String numero,
                            @JsonAlias("valor") BigDecimal valor,
                            @JsonAlias("nome") String nome,
                            @JsonAlias("dtExpiracao") LocalDateTime dtExpiracao,
                            @JsonAlias("codigo") String codigo,
                            @JsonAlias("status") String status,
                            @JsonAlias("tpPgtoId")  Long tpPgtoId,

                            @JsonAlias("pedidoUuid") UUID pedidoUuid
                            ) {}
