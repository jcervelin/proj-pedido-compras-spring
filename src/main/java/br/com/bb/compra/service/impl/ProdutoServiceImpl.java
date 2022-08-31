package br.com.bb.compra.service.impl;

import br.com.bb.compra.converter.ProdutoConverter;
import br.com.bb.compra.model.Produto;
import br.com.bb.compra.model.entity.ProdutoEntity;
import br.com.bb.compra.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl {

    private final ProdutoRepository repository;

    public Produto salvar(Produto novoProduto) {
        final ProdutoEntity produtoEntity = ProdutoConverter.convertTo(novoProduto);
        final ProdutoEntity produtoSalvo = repository.save(produtoEntity);
        return ProdutoConverter.convertTo(produtoSalvo);
    }

    public Produto buscaPorId(Long id) {
        final ProdutoEntity produtoSalvo = repository.findById(id)
                .orElseThrow(RuntimeException::new);
        return ProdutoConverter.convertTo(produtoSalvo);
    }


}
