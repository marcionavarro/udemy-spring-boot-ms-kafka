package io.github.marcionavarro.icompras.faturamento.mapper;

import io.github.marcionavarro.icompras.faturamento.model.Cliente;
import io.github.marcionavarro.icompras.faturamento.model.ItemPedido;
import io.github.marcionavarro.icompras.faturamento.model.Pedido;
import io.github.marcionavarro.icompras.faturamento.subscriber.representation.DetalheItemPedidoRepresentation;
import io.github.marcionavarro.icompras.faturamento.subscriber.representation.DetalhePedidoRepresentation;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoMapper {

    public Pedido map(DetalhePedidoRepresentation representation) {
        Cliente cliente = new Cliente(
            representation.nome(),
            representation.cpf(),
            representation.logradouro(),
            representation.numero(),
            representation.bairro(),
            representation.email(),
            representation.telefone()
        );

        List<ItemPedido> itens = representation.itens()
            .stream().map(this::mapItem).toList();

        return new Pedido(
            representation.codigo(),
            cliente,
            representation.dataPedido(),
            representation.total(),
            itens
        );
    }

    private ItemPedido mapItem(DetalheItemPedidoRepresentation itemRepresentation) {
        return new ItemPedido(
            itemRepresentation.codigoProduto(),
            itemRepresentation.nome(),
            itemRepresentation.valorUnitario(),
            itemRepresentation.quantidade(),
            itemRepresentation.total()
        );
    }
}
