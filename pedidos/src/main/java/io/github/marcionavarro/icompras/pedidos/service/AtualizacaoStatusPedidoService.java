package io.github.marcionavarro.icompras.pedidos.service;

import io.github.marcionavarro.icompras.pedidos.model.enums.StatusPedido;
import io.github.marcionavarro.icompras.pedidos.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AtualizacaoStatusPedidoService {

    private final PedidoRepository repository;

    @Transactional
    public void atualizarStatus(
        Long codigo,
        StatusPedido status,
        String urlNotafiscal,
        String rastreio) {
        repository.findById(codigo).ifPresent(pedido -> {
            pedido.setStatus(status);
            pedido.setUrlNotaFiscal(urlNotafiscal);
            pedido.setCodigoRastreio(rastreio);
        });
    }
}
