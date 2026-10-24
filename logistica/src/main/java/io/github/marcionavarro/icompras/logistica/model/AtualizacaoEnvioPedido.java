package io.github.marcionavarro.icompras.logistica.model;

public record AtualizacaoEnvioPedido(
    Long codigo,
    StatusPedido status,
    String codigoRastreio
) {
}
