package io.github.marcionavarro.icompras.produtos.repository;

import io.github.marcionavarro.icompras.produtos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
