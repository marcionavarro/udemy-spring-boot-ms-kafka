package io.github.marcionavarro.icompras.faturamento.config;

import io.github.marcionavarro.icompras.faturamento.config.props.MinioProps;
import io.minio.MinioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BucketConfig {

    private final MinioProps props;

    @Bean
    public MinioClient bucketClient() {
        return MinioClient.builder()
            .endpoint(props.getUrl())
            .credentials(props.getAccessKey(), props.getSecretKey())
            .build();
    }
}
