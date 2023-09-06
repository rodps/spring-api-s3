package br.com.rodrigo.imobiliaria.domain.imovel;

import jakarta.persistence.Embeddable;

@Embeddable
public class Endereco {
    private String cidade;
    private String uf;
    private String logradouro;
    private String numero;

    public Endereco(DadosEndereco dados) {
        this.cidade = dados.cidade();
        this.uf = dados.uf();
        this.logradouro = dados.logradouro();
        this.numero = dados.numero();
    }

    public Endereco(String cidade, String uf, String logradouro, String numero) {
        this.cidade = cidade;
        this.uf = uf;
        this.logradouro = logradouro;
        this.numero = numero;
    }

    public Endereco() {}
}
