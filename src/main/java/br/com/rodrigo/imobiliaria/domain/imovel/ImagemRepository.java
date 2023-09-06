package br.com.rodrigo.imobiliaria.domain.imovel;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImagemRepository extends JpaRepository<Imagem, Long> {
    public List<Imagem> findByImovelId(Long imovelId);
}
