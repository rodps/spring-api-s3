package br.com.rodrigo.imobiliaria.domain.imovel;

import jakarta.validation.constraints.NotBlank;

public record DadosEndereco(
        @NotBlank
        String cidade,
        @NotBlank
        String uf,
        @NotBlank
        String logradouro,
        @NotBlank
        String numero,
        String complemento
) {
}
