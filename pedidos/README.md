# 🧾 Microserviço de Pedidos

O microsserviço `pedidos` é o coração do sistema. Ele coordena a criação do pedido, a validação dos itens, a solicitação de pagamento, o processamento de eventos e a atualização do status de cada pedido.

## ✨ Funcionalidades

- Criação de pedidos;
- Validação de cliente e itens;
- Solicitação de pagamento;
- Atualização de status de pagamento;
- Integração com clientes e produtos por HTTP;
- Publicação de eventos no Kafka para faturamento e logística;
- Consulta de detalhes completos do pedido.

## 🌐 Endpoints

| Método | Endpoint | Descrição |
| --- | --- | --- |
| `POST` | `/pedidos` | Cria um novo pedido |
| `POST` | `/pedidos/pagamentos` | Adiciona nova tentativa de pagamento |
| `GET` | `/pedidos/{codigo}` | Busca detalhes do pedido |

## 🧱 Tecnologias

- Java 25
- Spring Boot
- Spring Web MVC
- Spring Data JPA
- PostgreSQL
- Spring Cloud OpenFeign
- Spring Kafka
- Lombok
- MapStruct

## 📦 Dependências

- Banco PostgreSQL em `localhost:5555`
- Base `icompraspedidos`
- Kafka em `localhost:29092`
- Microserviços de clientes e produtos em execução

## 🔄 Eventos Kafka

- Produz: `icompras.pedidos-pagos`
- Consome: `icompras.pedidos-faturados` e `icompras.pedidos-enviados`

## ▶️ Como executar

```powershell
cd pedidos
.\mvnw.cmd spring-boot:run
```

A API ficará disponível em:

- `http://localhost:8080`

## 🔗 Fluxo principal

1. Cliente e produtos são validados;
2. O pedido é salvo;
3. A solicitação de pagamento é enviada;
4. Quando o pagamento é aprovado, o pedido é publicado como pago;
5. O sistema processa a atualização do status e o fluxo segue para faturamento e logística.
