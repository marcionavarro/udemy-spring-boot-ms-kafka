package io.github.marcionavarro.icompras.pedidos.subscriber.representation;

import io.github.marcionavarro.icompras.pedidos.model.enums.StatusPedido;

public record AtualizacaoStatusPedidoRepresentation(
    Long codigo,
    StatusPedido status,
    String urlNotaFiscal,
    String codigoRastreio
) {
}
