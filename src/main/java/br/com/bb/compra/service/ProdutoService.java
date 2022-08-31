package br.com.bb.compra.service;

import br.com.bb.compra.model.Produto;

import java.util.List;

public interface ProdutoService {
    Produto salvar(Produto novoProduto);

    List<Produto> salvarLista(List<Produto> novoProduto);

    Produto buscaPorId(Long id);

    boolean isEmpty();
}
