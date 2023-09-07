package br.com.rodrigo.imobiliaria.domain.imovel.dto;

import br.com.rodrigo.imobiliaria.domain.imovel.Caracteristicas;
import br.com.rodrigo.imobiliaria.domain.imovel.Endereco;
import br.com.rodrigo.imobiliaria.domain.imovel.Imovel;

public record DadosDetalhamentoImovel(
        String nome,
        Double valor,
        String descricao,
        Endereco endereco,
        Caracteristicas caracteristicas) {

    public DadosDetalhamentoImovel(Imovel imovel) {
        this(imovel.getNome(), imovel.getValor(), imovel.getDescricao(), imovel.getEndereco(), imovel.getCaracteristicas());
    }
}