package br.com.rodrigo.imobiliaria.domain.usuario.validacao;

import br.com.rodrigo.imobiliaria.domain.usuario.dto.DadosCadastroUsuario;
import br.com.rodrigo.imobiliaria.exceptions.ValidacaoException;
import org.springframework.stereotype.Component;

@Component
public class ValidarTamanhoDaSenha implements ValidadorCadastroUsuario {

    public void validar(DadosCadastroUsuario dadosCadastroUsuario) throws ValidacaoException {
        if (dadosCadastroUsuario.senha().length() < 6){
            throw new ValidacaoException("A senha deve possuir no mínimo 6 caracteres");
        }
    }
}
