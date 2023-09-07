package br.com.rodrigo.imobiliaria.domain.imovel;

import br.com.rodrigo.imobiliaria.domain.imovel.dto.DadosCaracteristicas;
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

    public Integer getQuartos() {
        return quartos;
    }

    public void setQuartos(Integer quartos) {
        this.quartos = quartos;
    }

    public Integer getSuites() {
        return suites;
    }

    public void setSuites(Integer suites) {
        this.suites = suites;
    }

    public Boolean getGaragem() {
        return garagem;
    }

    public void setGaragem(Boolean garagem) {
        this.garagem = garagem;
    }

    public Integer getBanheiros() {
        return banheiros;
    }

    public void setBanheiros(Integer banheiros) {
        this.banheiros = banheiros;
    }
}
