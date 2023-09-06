package br.com.rodrigo.imobiliaria.domain.imovel;

import jakarta.persistence.Embeddable;

@Embeddable
public class Caracteristicas {
    private Integer quartos;
    private Integer suites;
    private Boolean garagem;
    private Integer banheiros;

    public Caracteristicas(DadosCaracteristicas dados) {
        this.quartos = dados.quartos();
        this.suites = dados.suites();
        this.garagem = dados.garagem();
        this.banheiros = dados.banheiros();
    }

    public Caracteristicas(Integer quartos, Integer suites, Boolean garagem, Integer banheiros) {
        this.quartos = quartos;
        this.suites = suites;
        this.garagem = garagem;
        this.banheiros = banheiros;
    }

    public Caracteristicas() {}
}
