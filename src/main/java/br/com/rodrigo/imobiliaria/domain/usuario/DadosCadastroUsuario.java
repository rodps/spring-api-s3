package br.com.rodrigo.imobiliaria.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroUsuario(@NotBlank String login, @NotBlank String senha) {
}
