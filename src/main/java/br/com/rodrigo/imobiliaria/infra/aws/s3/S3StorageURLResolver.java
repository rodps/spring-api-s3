package br.com.rodrigo.imobiliaria.infra.aws.s3;

import br.com.rodrigo.imobiliaria.infra.storage.StorageURLResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class S3StorageURLResolver implements StorageURLResolver {

    @Value("${aws.s3.bucket}")
    private String BUCKET;

    @Override
    public String getUrl(String filename) {
        return "https://" + BUCKET + ".s3.amazonaws.com/" + filename;
    }
}
