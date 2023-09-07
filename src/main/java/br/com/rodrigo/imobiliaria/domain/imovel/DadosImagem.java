package br.com.rodrigo.imobiliaria.domain.imovel;


import br.com.rodrigo.imobiliaria.infra.storage.StorageUrlResolver;

public record DadosImagem(Long id, String nome, String url) {

    public DadosImagem(Imagem imagem, StorageUrlResolver urlResolver) {
        this(imagem.getId(), imagem.getNome(), urlResolver.resolve(imagem.getNome()));
    }
}
