package io.github.marcionavarro.icompras.pedidos.controller;

import io.github.marcionavarro.icompras.pedidos.controller.dto.RecebimentoCallbackPagamentoDTO;
import io.github.marcionavarro.icompras.pedidos.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pedidos/callback-pagamentos")
@RequiredArgsConstructor
public class RecebimentoPagamentoCallbackPagamentoController {

    private final PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Object> atualizarStatusPagamento(
        @RequestBody RecebimentoCallbackPagamentoDTO body,
        @RequestHeader(required = true, name = "apiKey") String apiKey
    ) {
        pedidoService.atualizarStatusPagamento(
            body.codigo(),
            body.chavePagamento(),
            body.status(),
            body.observacoes()
        );
        return ResponseEntity.ok().build();
    }
}
