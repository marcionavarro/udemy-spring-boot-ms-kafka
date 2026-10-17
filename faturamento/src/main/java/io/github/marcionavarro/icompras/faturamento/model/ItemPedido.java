package io.github.marcionavarro.icompras.faturamento.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ItemPedido {

    Long codigo;
    String nome;
    BigDecimal valorUnitario;
    Integer quantidade;
    BigDecimal total;
}
