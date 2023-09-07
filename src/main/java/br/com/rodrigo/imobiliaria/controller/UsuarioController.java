package br.com.rodrigo.imobiliaria.controller;

import br.com.rodrigo.imobiliaria.domain.usuario.*;
import br.com.rodrigo.imobiliaria.domain.usuario.dto.DadosCadastroUsuario;
import br.com.rodrigo.imobiliaria.domain.usuario.service.CadastrarUsuarioService;
import br.com.rodrigo.imobiliaria.exceptions.ValidacaoException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CadastrarUsuarioService cadastrarUsuarioService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroUsuario dadosCadastroUsuario, UriComponentsBuilder uriComponentsBuilder) throws ValidacaoException {
        Usuario usuario = cadastrarUsuarioService.cadastrar(dadosCadastroUsuario);
        var uri = uriComponentsBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
