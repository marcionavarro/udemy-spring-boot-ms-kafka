package io.github.marcionavarro.icompras.faturamento.subscriber.representation;

import java.math.BigDecimal;

public record DetalheItemPedidoRepresentation(
    Long codigoProduto,
    String nome,
    BigDecimal valorUnitario,
    Integer quantidade,
    BigDecimal total
) {
}
