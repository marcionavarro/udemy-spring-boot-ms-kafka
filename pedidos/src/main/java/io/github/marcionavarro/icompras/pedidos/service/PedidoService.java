package io.github.marcionavarro.icompras.pedidos.service;

import io.github.marcionavarro.icompras.pedidos.client.ServicoBancarioClient;
import io.github.marcionavarro.icompras.pedidos.model.Pedido;
import io.github.marcionavarro.icompras.pedidos.model.enums.StatusPedido;
import io.github.marcionavarro.icompras.pedidos.repository.ItemPedidoRepository;
import io.github.marcionavarro.icompras.pedidos.repository.PedidoRepository;
import io.github.marcionavarro.icompras.pedidos.validator.PedidoValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository repository;
    private final ItemPedidoRepository itemPedidoRepository;
    private final PedidoValidator validator;
    private final ServicoBancarioClient servicoBancarioClient;

    @Transactional
    public Pedido criarPedido(Pedido pedido) {
        validator.validar(pedido);
        realizarPersistencia(pedido);
        enviarSolicitacaoDePagamento(pedido);
        return pedido;
    }

    private void enviarSolicitacaoDePagamento(Pedido pedido) {
        var chavePagamento = servicoBancarioClient.solicitarPagamento(pedido);
        pedido.setChavePagamento(chavePagamento);
    }

    private void realizarPersistencia(Pedido pedido) {
        repository.save(pedido);
        itemPedidoRepository.saveAll(pedido.getItens());
    }

    public void atualizarStatusPagamento(
        Long codigoPedido,
        String chavePagamento,
        boolean sucesso,
        String observacoes
    ) {
        var pedidoEncontrado = repository.
            findByCodigoAndChavePagamento(codigoPedido, chavePagamento);

        if (pedidoEncontrado.isEmpty()) {
            var msg = String.format(
                "Pedido com código %d e chave de pagamento %s não encontrado",
                codigoPedido,
                chavePagamento
            );

            log.error(msg);
            return;
        }

        Pedido pedido = pedidoEncontrado.get();

        if (sucesso) {
            pedido.setStatus(StatusPedido.PAGO);
        } else {
            pedido.setStatus(StatusPedido.ERRO_PAGAMENTO);
            pedido.setObservacoes(observacoes);
        }
        repository.save(pedido);
    }
}
