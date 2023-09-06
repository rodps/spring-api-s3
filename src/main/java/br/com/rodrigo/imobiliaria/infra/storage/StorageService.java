package br.com.rodrigo.imobiliaria.infra.storage;

import org.springframework.core.io.UrlResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;

public interface StorageService {
    String store(MultipartFile file);
    void delete(String fileName);
    UrlResource loadAsUrlResource(String fileName);
    void init();
}
