package io.github.marcionavarro.icompras.pedidos.controller.dto;

import io.github.marcionavarro.icompras.pedidos.model.enums.TipoPagamento;

public record DadosPagamentoDTO(
    String dados,
    TipoPagamento tipoPagamento
) {
}
