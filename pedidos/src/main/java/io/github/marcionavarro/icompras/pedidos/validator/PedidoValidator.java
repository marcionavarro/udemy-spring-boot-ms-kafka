package io.github.marcionavarro.icompras.pedidos.validator;

import io.github.marcionavarro.icompras.pedidos.client.ProdutosClient;
import io.github.marcionavarro.icompras.pedidos.client.representation.ProdutoRepresentation;
import io.github.marcionavarro.icompras.pedidos.model.Pedido;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PedidoValidator {

    private final ProdutosClient produtosClient;

    public void validar(Pedido pedido) {
    }
}
