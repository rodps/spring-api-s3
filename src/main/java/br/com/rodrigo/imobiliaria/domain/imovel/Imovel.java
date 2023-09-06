package br.com.rodrigo.imobiliaria.domain.imovel;

import jakarta.persistence.*;

@Entity
@Table(name = "imoveis")
public class Imovel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double valor;
    private String descricao;
    @Embedded
    private Endereco endereco;
    @Embedded
    private Caracteristicas caracteristicas;

    public Imovel(DadosCadastroImovel dados) {
        this.nome = dados.nome();
        this.valor = dados.valor();
        this.descricao = dados.descricao();
        this.endereco = new Endereco(dados.endereco());
        this.caracteristicas = new Caracteristicas(dados.caracteristicas());
    }

    public Imovel() {}

    public Imovel(Long id, String nome, Double valor, String descricao, Endereco endereco, Caracteristicas caracteristicas) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
        this.endereco = endereco;
        this.caracteristicas = caracteristicas;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setCaracteristicas(Caracteristicas caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Caracteristicas getCaracteristicas() {
        return caracteristicas;
    }
}
