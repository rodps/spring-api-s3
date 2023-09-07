package br.com.rodrigo.imobiliaria.domain.usuario.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroUsuario(@NotBlank String login, @NotBlank String senha) {
}
