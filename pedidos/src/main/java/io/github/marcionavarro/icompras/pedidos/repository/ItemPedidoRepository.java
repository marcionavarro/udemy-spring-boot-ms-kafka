package io.github.marcionavarro.icompras.pedidos.repository;

import io.github.marcionavarro.icompras.pedidos.model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}
