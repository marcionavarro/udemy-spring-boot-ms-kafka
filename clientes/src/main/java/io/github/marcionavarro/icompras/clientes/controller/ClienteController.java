package io.github.marcionavarro.icompras.clientes.controller;

import io.github.marcionavarro.icompras.clientes.modal.Cliente;
import io.github.marcionavarro.icompras.clientes.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @PostMapping
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente) {
        var clienteSalvo = service.salvar(cliente);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("{codigo}")
    public ResponseEntity<Cliente> obterDados(@PathVariable("codigo") Long codigo) {
        return service
            .obterPorCodigo(codigo)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
