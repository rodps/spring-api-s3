package br.com.rodrigo.imobiliaria.domain.usuario.validacao;

import br.com.rodrigo.imobiliaria.domain.usuario.dto.DadosCadastroUsuario;
import br.com.rodrigo.imobiliaria.exceptions.ValidacaoException;

public interface ValidadorCadastroUsuario {
    public void validar(DadosCadastroUsuario dadosCadastroUsuario) throws ValidacaoException;
}
