package io.github.marcionavarro.icompras.pedidos.service;

import io.github.marcionavarro.icompras.pedidos.client.ServicoBancarioClient;
import io.github.marcionavarro.icompras.pedidos.model.DadosPagamento;
import io.github.marcionavarro.icompras.pedidos.model.Pedido;
import io.github.marcionavarro.icompras.pedidos.model.enums.StatusPedido;
import io.github.marcionavarro.icompras.pedidos.model.enums.TipoPagamento;
import io.github.marcionavarro.icompras.pedidos.model.exception.ItemNaoEncontradoException;
import io.github.marcionavarro.icompras.pedidos.repository.ItemPedidoRepository;
import io.github.marcionavarro.icompras.pedidos.repository.PedidoRepository;
import io.github.marcionavarro.icompras.pedidos.validator.PedidoValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public void adicionarNovoPagamento(
        Long codigoPedido,
        String dados,
        TipoPagamento tipo
    ) {
        var pedidoEncontrado = repository.findById(codigoPedido);

        if (pedidoEncontrado.isEmpty()) {
            throw new ItemNaoEncontradoException("Pedido não encontrado para o código: " + codigoPedido);
        }

        var pedido = pedidoEncontrado.get();

        DadosPagamento dadosPagamento = new DadosPagamento();
        dadosPagamento.setTipoPagamento(tipo);
        dadosPagamento.setDados(dados);

        pedido.setDadosPagamento(dadosPagamento);
        pedido.setStatus(StatusPedido.REALIZADO);
        pedido.setObservacoes("Novo pagamento realiado, aguardando o processamento do pagamento");

        String novaChavePagamento = servicoBancarioClient.solicitarPagamento(pedido);
        pedido.setChavePagamento(novaChavePagamento);

        repository.save(pedido);

    }
}
