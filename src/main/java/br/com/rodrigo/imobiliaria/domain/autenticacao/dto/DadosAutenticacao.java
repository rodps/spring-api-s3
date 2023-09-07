package br.com.rodrigo.imobiliaria.domain.autenticacao.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosAutenticacao(@NotBlank String login, @NotBlank String senha) {
}
