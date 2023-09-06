package br.com.rodrigo.imobiliaria.domain.imovel;

import jakarta.persistence.*;

@Entity
@Table(name = "imagens")
public class Imagem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(name = "imovel_id")
    private Long imovelId;

    public Imagem(String nome, Long imovelId) {
        this.nome = nome;
        this.imovelId = imovelId;
    }

    public Imagem() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getImovelId() {
        return imovelId;
    }

    public void setImovelId(Long imovelId) {
        this.imovelId = imovelId;
    }
}
