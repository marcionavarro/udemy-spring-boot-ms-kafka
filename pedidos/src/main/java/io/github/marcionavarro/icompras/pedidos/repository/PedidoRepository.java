package io.github.marcionavarro.icompras.pedidos.repository;

import io.github.marcionavarro.icompras.pedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
