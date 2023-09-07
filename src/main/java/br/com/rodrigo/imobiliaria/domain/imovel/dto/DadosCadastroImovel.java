package br.com.rodrigo.imobiliaria.domain.imovel.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroImovel(
        @NotBlank
        String nome,
        @NotNull
        Double valor,
        @NotBlank
        String descricao,
        @NotNull
        @Valid
        DadosEndereco endereco,
        @NotNull
        @Valid
        DadosCaracteristicas caracteristicas) {
}
