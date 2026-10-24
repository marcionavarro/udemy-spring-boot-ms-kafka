package io.github.marcionavarro.icompras.logistica.subscriber;

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

    @KafkaListener(
        groupId = "${spring.kafka.consumer.group-id}",
        topics = "${icompras.config.kafka.topics.pedidos-faturados}"
    )
    public void listener(String json) {
        log.info("Recebebdi pedido para envio: {} ", json);

        try {
            var representation = objectMapper
                .readValue(json, AtualizacaoFaturamentoRepresentation.class);
        } catch (Exception e) {
            log.error("Erro ao preparar pedido para envio", e.getMessage());
        }
    }
}
