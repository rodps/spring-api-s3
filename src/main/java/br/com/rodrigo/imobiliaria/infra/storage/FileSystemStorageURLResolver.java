package br.com.rodrigo.imobiliaria.infra.storage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileSystemStorageURLResolver implements StorageURLResolver {

    @Value("${app.baseurl}")
    private String BASEURL;

    @Override
    public String getUrl(String filename) {
        return BASEURL + "/imoveis/images/" + filename;
    }
}
