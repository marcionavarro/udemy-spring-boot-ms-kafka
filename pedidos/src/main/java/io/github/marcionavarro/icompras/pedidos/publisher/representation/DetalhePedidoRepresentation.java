package io.github.marcionavarro.icompras.pedidos.publisher.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.marcionavarro.icompras.pedidos.model.enums.StatusPedido;

import java.math.BigDecimal;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record DetalhePedidoRepresentation(
    Long codigo,
    Long codigoCliente,
    String nome,
    String cpf,
    String logradouro,
    String numero,
    String bairro,
    String email,
    String telefone,
    String dataPedido,
    BigDecimal total,
    StatusPedido status,
    String urlNotaFiscal,
    String codigoRastreio,
    List<DetalheItemPedidoRepresentation> itens
) {
}
