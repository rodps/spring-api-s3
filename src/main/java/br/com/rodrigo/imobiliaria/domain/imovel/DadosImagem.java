package br.com.rodrigo.imobiliaria.domain.imovel;

import br.com.rodrigo.imobiliaria.infra.storage.StorageURLResolver;

public record DadosImagem(Long id, String nome, String url) {

    public DadosImagem(Imagem imagem, StorageURLResolver urlResolver) {
        this(imagem.getId(), imagem.getNome(), urlResolver.getUrl(imagem.getNome()));
    }
}
