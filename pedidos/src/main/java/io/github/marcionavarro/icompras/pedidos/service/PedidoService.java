package io.github.marcionavarro.icompras.pedidos.service;

import io.github.marcionavarro.icompras.pedidos.model.Pedido;
import io.github.marcionavarro.icompras.pedidos.repository.ItemPedidoRepository;
import io.github.marcionavarro.icompras.pedidos.repository.PedidoRepository;
import io.github.marcionavarro.icompras.pedidos.validator.PedidoValidator;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository repository;
    private final ItemPedidoRepository itemPedidoRepository;
    private final PedidoValidator validator;

    public Pedido criarPedido(Pedido pedido) {}
}
