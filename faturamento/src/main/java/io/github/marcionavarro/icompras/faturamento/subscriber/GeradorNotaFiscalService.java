package io.github.marcionavarro.icompras.faturamento.subscriber;

import io.github.marcionavarro.icompras.faturamento.bucket.BucketFile;
import io.github.marcionavarro.icompras.faturamento.bucket.BucketService;
import io.github.marcionavarro.icompras.faturamento.model.Pedido;
import io.github.marcionavarro.icompras.faturamento.service.NotaFiscalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;

@Slf4j
@Service
@RequiredArgsConstructor
public class GeradorNotaFiscalService {

    private final NotaFiscalService notaFiscalService;
    private final BucketService bucketService;

    public void gerar(Pedido pedido) {
        log.info("Gerada nota fiscal para o pedido {}", pedido.codigo());

        try {
            byte[] byteArray = notaFiscalService.gerarNota(pedido);

            String nomeArquivo = String.format("notafiscal_pedido_%d.pdf", pedido.codigo());
            var file = new BucketFile(
                nomeArquivo, new ByteArrayInputStream(byteArray), MediaType.APPLICATION_PDF, byteArray.length);

            bucketService.upload(file);
        } catch (RuntimeException e) {
            log.error(e.getMessage(), e);
        }
    }
}
