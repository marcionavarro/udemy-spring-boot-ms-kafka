package io.github.marcionavarro.icompras.pedidos.controller.mappers;

import io.github.marcionavarro.icompras.pedidos.controller.dto.NovoPedidoDTO;
import io.github.marcionavarro.icompras.pedidos.model.Pedido;

public interface PedidoMapper {
    Pedido map(NovoPedidoDTO dto);
}
