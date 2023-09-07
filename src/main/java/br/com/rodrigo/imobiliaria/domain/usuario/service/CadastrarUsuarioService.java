package br.com.rodrigo.imobiliaria.domain.usuario.service;

import br.com.rodrigo.imobiliaria.domain.usuario.dto.DadosCadastroUsuario;
import br.com.rodrigo.imobiliaria.domain.usuario.Usuario;
import br.com.rodrigo.imobiliaria.domain.usuario.UsuarioRepository;
import br.com.rodrigo.imobiliaria.domain.usuario.validacao.ValidadorCadastroUsuario;
import br.com.rodrigo.imobiliaria.exceptions.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastrarUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private List<ValidadorCadastroUsuario> validadores;

    public Usuario cadastrar(DadosCadastroUsuario dadosCadastroUsuario) throws ValidacaoException {
        for (ValidadorCadastroUsuario v: validadores) {
            v.validar(dadosCadastroUsuario);
        }

        var senhaHash = passwordEncoder.encode(dadosCadastroUsuario.senha());

        Usuario usuario = new Usuario();
        usuario.setLogin(dadosCadastroUsuario.login());
        usuario.setSenha(senhaHash);
        usuarioRepository.save(usuario);

        return usuario;
    }
}
