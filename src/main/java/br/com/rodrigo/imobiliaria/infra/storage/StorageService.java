package br.com.rodrigo.imobiliaria.infra.storage;

import org.springframework.core.io.UrlResource;
import org.springframework.web.multipart.MultipartFile;


public interface StorageService {
    String store(MultipartFile file);
    void delete(String fileName);
    UrlResource loadAsUrlResource(String fileName);
    StorageUrlResolver getUrlResolver();
    void init();
}
