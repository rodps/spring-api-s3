package br.com.rodrigo.imobiliaria.infra.storage;

import org.springframework.core.io.UrlResource;
import org.springframework.web.multipart.MultipartFile;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

public interface StorageService {
    static String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    String store(MultipartFile file);
    void delete(String fileName);
    UrlResource loadAsUrlResource(String fileName);
    StorageURLResolver getURLResolver();
    void init();
}
