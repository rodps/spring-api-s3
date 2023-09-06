package br.com.rodrigo.imobiliaria.domain.imovel;

public record DadosImagem(Long id, String nome, String location) {

    public DadosImagem(Imagem imagem) {
        this(imagem.getId(), imagem.getNome(), "/imoveis/images/" + imagem.getNome());
    }
}
