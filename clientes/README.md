# 👤 Microserviço de Clientes

O microsserviço `clientes` é responsável por manter o cadastro de clientes e expor operações de consulta, criação e remoção através de endpoints REST.

## ✨ Funcionalidades

- Cadastro de clientes;
- Busca de cliente por código;
- Remoção de cliente;
- Persistência em PostgreSQL;
- Integração com o fluxo de pedidos via HTTP.

## 🌐 Endpoints

| Método | Endpoint | Descrição |
| --- | --- | --- |
| `POST` | `/clientes` | Salva um novo cliente |
| `GET` | `/clientes/{codigo}` | Busca um cliente pelo código |
| `DELETE` | `/clientes/{codigo}` | Remove um cliente |

## 🧱 Tecnologias

- Java 25
- Spring Boot
- Spring Web MVC
- Spring Data JPA
- PostgreSQL
- Lombok

## 📦 Dependências

- Banco PostgreSQL em `localhost:5555`
- Base `icomprasclientes`

## ▶️ Como executar

```powershell
cd clientes
.\mvnw.cmd spring-boot:run
```

A API ficará disponível em:

- `http://localhost:8082`

## 🔗 Integração

O serviço é consumido pelo microsserviço de pedidos para validar dados do cliente quando um pedido é criado ou consultado.
