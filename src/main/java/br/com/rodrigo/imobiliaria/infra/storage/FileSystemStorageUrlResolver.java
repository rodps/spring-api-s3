package br.com.rodrigo.imobiliaria.infra.storage;

import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class FileSystemStorageUrlResolver implements StorageUrlResolver {

    @Override
    public String resolve(String filename) {
        return UriComponentsBuilder.newInstance()
                .path("/imoveis/images/{filename}")
                .buildAndExpand(filename)
                .encode()
                .toString();
    }
}
