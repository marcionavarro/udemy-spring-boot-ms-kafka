# 🛍️ Microserviço de Produtos

O microsserviço `produtos` centraliza o cadastro e consulta do catálogo de produtos, permitindo que o sistema de pedidos valide a existência e os dados dos itens antes de processar a compra.

## ✨ Funcionalidades

- Cadastro de produtos;
- Consulta de produto por código;
- Exclusão de produto;
- Persistência em PostgreSQL;
- Suporte ao fluxo de pedido e faturamento.

## 🌐 Endpoints

| Método | Endpoint | Descrição |
| --- | --- | --- |
| `POST` | `/produtos` | Cria um novo produto |
| `GET` | `/produtos/{codigo}` | Busca um produto pelo código |
| `DELETE` | `/produtos/{codigo}` | Remove um produto |

## 🧱 Tecnologias

- Java 25
- Spring Boot
- Spring Web MVC
- Spring Data JPA
- PostgreSQL
- Lombok

## 📦 Dependências

- Banco PostgreSQL em `localhost:5555`
- Base `icomprasprodutos`

## ▶️ Como executar

```powershell
cd produtos
.\mvnw.cmd spring-boot:run
```

A API ficará disponível em:

- `http://localhost:8081`

## 🔗 Integração

O serviço é consultado pelo `pedidos` para carregar o nome e os detalhes dos produtos do pedido.
