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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
