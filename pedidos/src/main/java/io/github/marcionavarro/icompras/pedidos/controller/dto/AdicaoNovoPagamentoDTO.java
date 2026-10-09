package io.github.marcionavarro.icompras.pedidos.controller.dto;

import io.github.marcionavarro.icompras.pedidos.model.enums.TipoPagamento;

public record AdicaoNovoPagamentoDTO(
    Long codigoPedido,
    String dados,
    TipoPagamento tipoPagamento
) {
}
