package io.github.marcionavarro.icompras.logistica.subscriber.representation;

import io.github.marcionavarro.icompras.logistica.model.StatusPedido;

public record AtualizacaoFaturamentoRepresentation(
    Long codigo,
    StatusPedido status,
    String urlNotaFiscal
) {
}
