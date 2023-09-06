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
