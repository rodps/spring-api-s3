package br.com.rodrigo.imobiliaria.domain.imovel.dto;

import jakarta.validation.constraints.NotNull;

public record DadosCaracteristicas(
        @NotNull
        Integer quartos,
        @NotNull
        Boolean garagem,
        @NotNull
        Integer banheiros,
        @NotNull
        Integer suites
) {
}
