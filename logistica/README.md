# 🚚 Microserviço de Logística

O microsserviço `logistica` recebe a confirmação de faturamento, gera um código de rastreio e publica a atualização do status de envio para o restante do sistema.

## ✨ Funcionalidades

- Consumo do tópico `icompras.pedidos-faturados`;
- Geração de código de rastreio;
- Publicação do tópico `icompras.pedidos-enviados`;
- Encaminhamento do pedido para entrega;
- Atualização do status de envio no microsserviço de pedidos.

## 🧱 Tecnologias

- Java 25
- Spring Boot
- Spring Kafka
- Lombok

## 📦 Dependências

- Kafka em `localhost:29092`
- Tópico `icompras.pedidos-faturados`

## 🔄 Eventos Kafka

- Consome: `icompras.pedidos-faturados`
- Produz: `icompras.pedidos-enviados`

## ▶️ Como executar

```powershell
cd logistica
.\mvnw.cmd spring-boot:run
```

A API ficará disponível em:

- `http://localhost:8084`

## 🔗 Fluxo principal

1. Recebe o pedido faturado;
2. Gera um código de rastreio aleatório;
3. Publica o evento de envio;
4. O pedido volta ao microsserviço de pedidos com status atualizado.
