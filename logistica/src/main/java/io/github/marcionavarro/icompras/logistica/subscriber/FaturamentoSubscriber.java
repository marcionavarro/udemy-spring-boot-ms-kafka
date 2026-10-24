package io.github.marcionavarro.icompras.logistica.subscriber;

import io.github.marcionavarro.icompras.logistica.service.EnvioPedidoService;
import io.github.marcionavarro.icompras.logistica.subscriber.representation.AtualizacaoFaturamentoRepresentation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Slf4j
@Component
@RequiredArgsConstructor
public class FaturamentoSubscriber {

    private final ObjectMapper objectMapper;
    private final EnvioPedidoService service;

    @KafkaListener(
        groupId = "${spring.kafka.consumer.group-id}",
        topics = "${icompras.config.kafka.topics.pedidos-faturados}"
    )
    public void listener(String json) {
        log.info("Recebido pedido para envio: {} ", json);

        try {
            var representation = objectMapper
                .readValue(json, AtualizacaoFaturamentoRepresentation.class);

            service.enviar(representation.codigo(), representation.urlNotaFiscal());

            log.info("Pedido processado com sucesso: {}", representation.codigo());

        } catch (Exception e) {
            log.error("Erro ao preparar pedido para envio", e.getMessage());
        }
    }
}
