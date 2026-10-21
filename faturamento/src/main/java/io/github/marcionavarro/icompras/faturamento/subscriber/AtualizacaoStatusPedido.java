package io.github.marcionavarro.icompras.faturamento.subscriber;

import io.github.marcionavarro.icompras.faturamento.publisher.representation.StatusPedido;

public record AtualizacaoStatusPedido(
    Long codigo,
    StatusPedido status,
    String urlNotaFiscal
) {
}
