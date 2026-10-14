package io.github.marcionavarro.icompras.faturamento.subscriber;

import io.github.marcionavarro.icompras.faturamento.model.Pedido;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GeradorNotaFiscalService {

    public void gerar(Pedido pedido) {
        log.info("Gerada nota fiscal para o pedido {}", pedido.codigo());
    }
}
