package br.com.rodrigo.imobiliaria.controller;

import br.com.rodrigo.imobiliaria.domain.usuario.DadosAutenticacao;
import br.com.rodrigo.imobiliaria.domain.usuario.Usuario;
import br.com.rodrigo.imobiliaria.domain.usuario.DadosJwt;
import br.com.rodrigo.imobiliaria.infra.security.JwtService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid DadosAutenticacao dadosAutenticacao) {
        var authToken = new UsernamePasswordAuthenticationToken(dadosAutenticacao.login(), dadosAutenticacao.senha());
        var authentication = authenticationManager.authenticate(authToken);
        var jwtToken = jwtService.gerarToken((Usuario) authentication.getPrincipal());
        return ResponseEntity.ok().body(new DadosJwt(jwtToken));
    }
}
