package br.com.bb.compra.service;

import br.com.bb.compra.model.Produto;
import br.com.bb.compra.model.entity.ProdutoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;

import java.util.List;

public interface ProdutoService {
    Produto salvar(Produto novoProduto);

    List<Produto> salvarLista(List<Produto> novoProduto);

    Produto buscaPorId(Long id);

    boolean isEmpty();

    PagedModel<Produto> listar(String filtro, Pageable pageable);
    PagedModel<Produto> listar(Pageable pageable);
}
