package io.github.marcionavarro.icompras.faturamento;

import io.github.marcionavarro.icompras.faturamento.config.props.MinioProps;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(MinioProps.class)
public class FaturamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FaturamentoApplication.class, args);
	}

}
