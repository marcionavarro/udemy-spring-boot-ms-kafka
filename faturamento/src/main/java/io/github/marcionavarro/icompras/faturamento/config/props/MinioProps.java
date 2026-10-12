package io.github.marcionavarro.icompras.faturamento.config.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "minio")
@Data
public class MinioProps {

    private String url;
    private String accessKey;
    private String secretKey;
    private String bucketName;
}
