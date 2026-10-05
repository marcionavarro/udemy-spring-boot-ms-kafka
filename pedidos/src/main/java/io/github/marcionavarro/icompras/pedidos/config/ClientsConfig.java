package io.github.marcionavarro.icompras.pedidos.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "io.github.marcionavarro.icompras.pedidos.clients")
public class ClientsConfig {
}
