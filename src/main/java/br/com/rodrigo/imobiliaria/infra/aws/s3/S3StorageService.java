package br.com.rodrigo.imobiliaria.infra.aws.s3;

import br.com.rodrigo.imobiliaria.infra.storage.StorageFileNotFoundException;
import br.com.rodrigo.imobiliaria.infra.storage.StorageService;
import io.awspring.cloud.s3.ObjectMetadata;
import io.awspring.cloud.s3.S3Operations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Service("s3")
@Primary
class S3StorageService implements StorageService {
    private final S3Operations s3Operations;
    @Value("${aws.s3.bucket}")
    private String BUCKET;

    @Autowired
    private S3StorageUrlResolver urlResolver;

    public S3StorageService(S3Operations s3Operations) {
        this.s3Operations = s3Operations;
    }

    @Override
    public String store(MultipartFile file) {
        String filename = file.getOriginalFilename();
        try (InputStream is = file.getInputStream()) {
            var result = s3Operations.upload(BUCKET, filename, is,
                    ObjectMetadata.builder().contentType(file.getContentType()).build());
            return filename;
        } catch (IOException e) {
            throw new StorageFileNotFoundException(e.getMessage());
        }
    }

    @Override
    public void delete(String fileName) {
        s3Operations.deleteObject(BUCKET, fileName);
    }

    @Override
    public UrlResource loadAsUrlResource(String fileName) {
        var resource = s3Operations.download(BUCKET, fileName);
        try {
            UrlResource urlResource = new UrlResource(resource.getURI());
            return urlResource;
        } catch (IOException e) {
            throw new StorageFileNotFoundException(e.getMessage());
        }
    }

    @Override
    public S3StorageUrlResolver getUrlResolver() {
        return urlResolver;
    }

    @Override
    public void init() {

    }
}