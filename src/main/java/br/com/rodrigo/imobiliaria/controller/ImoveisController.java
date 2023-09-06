package br.com.rodrigo.imobiliaria.controller;

import br.com.rodrigo.imobiliaria.domain.imovel.DadosCadastroImovel;
import br.com.rodrigo.imobiliaria.domain.imovel.Imovel;
import br.com.rodrigo.imobiliaria.domain.imovel.ImovelRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/imoveis")
public class ImoveisController {

    @Autowired
    private ImovelRepository imovelRepository;

    @PostMapping()
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroImovel dadosCadastroImovel, UriComponentsBuilder uriComponentsBuilder) {
        var imovel = new Imovel(dadosCadastroImovel);
        imovelRepository.save(imovel);

        var uri = uriComponentsBuilder.path("/imoveis/{id}").buildAndExpand(imovel.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
