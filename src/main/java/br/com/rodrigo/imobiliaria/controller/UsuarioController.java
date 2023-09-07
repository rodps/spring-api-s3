package br.com.rodrigo.imobiliaria.controller;

import br.com.rodrigo.imobiliaria.domain.usuario.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private PasswordEncoder passwordEncoder;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroUsuario dadosCadastroUsuario, UriComponentsBuilder uriComponentsBuilder) {
        var usuarioExiste = usuarioRepository.findByLogin(dadosCadastroUsuario.login());
        if (usuarioExiste != null) {
            return ResponseEntity.badRequest().body("Já existe um usuário com o mesmo login.");
        }
        var senhaHash = passwordEncoder.encode(dadosCadastroUsuario.senha());
        Usuario usuario = new Usuario();
        usuario.setLogin(dadosCadastroUsuario.login());
        usuario.setSenha(senhaHash);
        usuarioRepository.save(usuario);
        var uri = uriComponentsBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
