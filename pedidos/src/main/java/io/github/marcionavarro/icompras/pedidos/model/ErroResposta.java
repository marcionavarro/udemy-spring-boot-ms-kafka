package io.github.marcionavarro.icompras.pedidos.model;

public record ErroResposta(
    String message,
    String campo,
    String erro
) {
}
