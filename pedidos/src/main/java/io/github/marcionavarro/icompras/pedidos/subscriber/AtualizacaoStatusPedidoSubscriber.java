package io.github.marcionavarro.icompras.pedidos.subscriber;

import io.github.marcionavarro.icompras.pedidos.service.AtualizacaoStatusPedidoService;
import io.github.marcionavarro.icompras.pedidos.subscriber.representation.AtualizacaoStatusPedidoRepresentation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Slf4j
@Component
@RequiredArgsConstructor
public class AtualizacaoStatusPedidoSubscriber {

    private final AtualizacaoStatusPedidoService service;
    private final ObjectMapper objectMapper;

    @KafkaListener(groupId = "${spring.kafka.consumer.group-id}", topics = {
        "${icompras.config.kafka.topics.pedidos-faturados}",
        "${icompras.config.kafka.topics.pedidos-enviados}",
    })
    public void receberAtualizacao(String json) {
        try {
            log.info("Recebendo atualizacao de status: {}", json);

            var atualizacaoStatus = objectMapper
                .readValue(json, AtualizacaoStatusPedidoRepresentation.class);

            service.atualizarStatus(
                atualizacaoStatus.codigo(),
                atualizacaoStatus.status(),
                atualizacaoStatus.urlNotaFiscal(),
                atualizacaoStatus.codigoRastreio()
            );

            log.info("Pedido atualizado com sucesso!");

        } catch (Exception e) {
            log.error("Erro ao atualizar status pedido: {}", e.getMessage());
        }
    }
}
