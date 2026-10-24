package io.github.marcionavarro.icompras.logistica.service;

import io.github.marcionavarro.icompras.logistica.model.AtualizacaoEnvioPedido;
import io.github.marcionavarro.icompras.logistica.model.StatusPedido;
import io.github.marcionavarro.icompras.logistica.publisher.EnvioPedidoPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class EnvioPedidoService {

    private final EnvioPedidoPublisher publisher;

    public void enviar(Long codigoPedido, String urlNotaFiscal) {
        var codigoRastreio = gerarCodigoRastreio();
        var atualizacaoEnvioPedido =
            new AtualizacaoEnvioPedido(codigoPedido, StatusPedido.ENVIADO, codigoRastreio);
        publisher.enviar(atualizacaoEnvioPedido);
    }

    private String gerarCodigoRastreio() {
        // AB123456789BR

        var random = new Random();

        char letra1 = (char) ('A' + random.nextInt(26));
        char letra2 = (char) ('A' + random.nextInt(26));

        int numeros = 100000000 + random.nextInt(90000000);
        return "" + letra1 + letra2 + numeros + "BR";
    }

}
