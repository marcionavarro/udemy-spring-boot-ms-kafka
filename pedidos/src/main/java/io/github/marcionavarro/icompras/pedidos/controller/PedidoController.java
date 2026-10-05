package io.github.marcionavarro.icompras.pedidos.controller;

import io.github.marcionavarro.icompras.pedidos.controller.dto.NovoPedidoDTO;
import io.github.marcionavarro.icompras.pedidos.controller.mappers.PedidoMapper;
import io.github.marcionavarro.icompras.pedidos.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService service;
    private final PedidoMapper mapper;

    public ResponseEntity<Object> criar(@RequestBody NovoPedidoDTO dto) {
        var pedido = mapper.map(dto);
        var novoPedido = service.criarPedido(pedido);
        return ResponseEntity.ok(novoPedido.getCodigo());
    }
}
