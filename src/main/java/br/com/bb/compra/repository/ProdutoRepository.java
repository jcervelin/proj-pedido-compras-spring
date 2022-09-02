package br.com.bb.compra.repository;

import br.com.bb.compra.model.entity.ProdutoEntity;
import br.com.bb.compra.model.entity.ProdutoProjecao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {


    List<ProdutoProjecao> findByDescricao(String descricao);
    // select * from tb_produto p where p.descricao = :descricao
}
