package io.github.marcionavarro.icompras.clientes.repository;

import io.github.marcionavarro.icompras.clientes.modal.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
