package br.com.rodrigo.imobiliaria.controller;

import br.com.rodrigo.imobiliaria.domain.imovel.*;
import br.com.rodrigo.imobiliaria.infra.storage.StorageService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;

@RestController
@RequestMapping("/imoveis")
public class ImoveisController {

    @Autowired
    private ImovelRepository imovelRepository;
    @Autowired
    private ImagemRepository imagemRepository;

    @Autowired
    private StorageService storageService;

    @PostMapping()
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroImovel dadosCadastroImovel, UriComponentsBuilder uriComponentsBuilder) {
        var imovel = new Imovel(dadosCadastroImovel);
        imovelRepository.save(imovel);

        var uri = uriComponentsBuilder.path("/imoveis/{id}").buildAndExpand(imovel.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var imovel = imovelRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoImovel(imovel));
    }

    @PostMapping("{id}/images")
    @Transactional
    public ResponseEntity uploadImage(@PathVariable Long id, @RequestParam("files") MultipartFile[] files) {
        var imovel = imovelRepository.findById(id);
        if (imovel.isEmpty()) {
            return ResponseEntity.badRequest().body("Não existe imóvel com este ID.");
        }
        for (MultipartFile file: files) {
            var fileName = storageService.store(file);
            var imagem = new Imagem(fileName, id);
            imagemRepository.save(imagem);
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("{id}/images")
    public ResponseEntity getImovelImages(@PathVariable Long id) {
        var imagens = imagemRepository.findByImovelId(id);
        return ResponseEntity.ok(imagens.stream().map(DadosImagem::new));
    }

    @DeleteMapping("/images/{id}")
    @Transactional
    public ResponseEntity deleteImage(@PathVariable Long id) {
        var imagem = imagemRepository.getReferenceById(id);
        imagemRepository.delete(imagem);
        storageService.delete(imagem.getNome());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/images/{filename}")
    public ResponseEntity loadImage(@PathVariable String filename) {
        UrlResource file = storageService.loadAsUrlResource(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + file.getFilename() + "\"")
                .header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
                .body(file);
    }
}
