# 🧾 Microserviço de Faturamento

O microsserviço `faturamento` é responsável por receber eventos de pedidos pagos, gerar a nota fiscal em PDF e publicar a atualização de faturamento para o restante do sistema.

## ✨ Funcionalidades

- Consumo do tópico `icompras.pedidos-pagos`;
- Geração de nota fiscal em PDF com JasperReports;
- Upload do arquivo para o MinIO;
- Publicação do evento `icompras.pedidos-faturados`;
- Armazenamento do link público da nota fiscal.

## 🧱 Tecnologias

- Java 25
- Spring Boot
- Spring Kafka
- JasperReports
- MinIO
- OkHttp
- Lombok

## 📦 Dependências

- Kafka em `localhost:29092`
- MinIO em `http://localhost:9000`
- Bucket configurado: `icompras.faturas`

## 🔄 Eventos Kafka

- Consome: `icompras.pedidos-pagos`
- Produz: `icompras.pedidos-faturados`

## ▶️ Como executar

```powershell
cd faturamento
.\mvnw.cmd spring-boot:run
```

A API ficará disponível em:

- `http://localhost:8083`

## 📝 Observações

A nota fiscal é gerada no formato PDF e salva no bucket de MinIO, com a URL retornada para o sistema de pedidos e para a logística.
