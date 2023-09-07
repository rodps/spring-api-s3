package br.com.rodrigo.imobiliaria.domain.usuario.validacao;

import br.com.rodrigo.imobiliaria.domain.usuario.dto.DadosCadastroUsuario;
import br.com.rodrigo.imobiliaria.domain.usuario.UsuarioRepository;
import br.com.rodrigo.imobiliaria.exceptions.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarSeUsuarioJaExiste implements ValidadorCadastroUsuario {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void validar(DadosCadastroUsuario dadosCadastroUsuario) throws ValidacaoException {
        var usuarioExiste = usuarioRepository.findByLogin(dadosCadastroUsuario.login());
        if (usuarioExiste != null) {
            throw new ValidacaoException("Já existe um usuário com o mesmo login.");
        }
    }
}
