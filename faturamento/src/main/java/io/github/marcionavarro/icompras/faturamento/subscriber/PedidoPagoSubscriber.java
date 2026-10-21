package io.github.marcionavarro.icompras.faturamento.subscriber;

import io.github.marcionavarro.icompras.faturamento.mapper.PedidoMapper;
import io.github.marcionavarro.icompras.faturamento.model.Pedido;
import io.github.marcionavarro.icompras.faturamento.service.GeradorNotaFiscalService;
import io.github.marcionavarro.icompras.faturamento.subscriber.representation.DetalhePedidoRepresentation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Slf4j
@Component
@RequiredArgsConstructor
public class PedidoPagoSubscriber {

    private final ObjectMapper mapper;
    private final GeradorNotaFiscalService service;
    private final PedidoMapper pedidoMapper;

    @KafkaListener(groupId = "icompras-faturamento", topics = "${icompras.config.kafka.topics.pedidos-pagos}")
    public void listener(String json) {
        try {
            log.info("Recebendo pedido para faturamento {}", json);
            var representation = mapper.readValue(json, DetalhePedidoRepresentation.class);
            Pedido pedido = pedidoMapper.map(representation);
            service.gerar(pedido);
        } catch (Exception e) {
            log.error("Erro na consumação do topico de pedidos pagos");
        }
    }
}
