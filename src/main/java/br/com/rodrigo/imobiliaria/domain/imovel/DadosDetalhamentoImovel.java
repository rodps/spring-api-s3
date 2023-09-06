package br.com.rodrigo.imobiliaria.domain.imovel;

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