package br.com.rodrigo.imobiliaria.infra.aws.s3;

import br.com.rodrigo.imobiliaria.infra.storage.StorageUrlResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class S3StorageUrlResolver implements StorageUrlResolver {

    @Value("${aws.s3.bucket}")
    private String BUCKET;

    @Override
    public String resolve(String filename) {
        return UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("{BUCKET}.s3.amazonaws.com")
                .path(filename)
                .buildAndExpand(BUCKET)
                .encode()
                .toString();
    }
}
