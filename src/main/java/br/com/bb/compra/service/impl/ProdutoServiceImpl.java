package br.com.bb.compra.service.impl;

import br.com.bb.compra.converter.ProdutoConverter;
import br.com.bb.compra.model.Produto;
import br.com.bb.compra.model.entity.ProdutoEntity;
import br.com.bb.compra.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl {

    private final ProdutoRepository repository;

    public Produto salvar(Produto novoProduto) {
        final ProdutoEntity produtoEntity = ProdutoConverter.convertProductTo(novoProduto);
        final ProdutoEntity produtoSalvo = repository.save(produtoEntity);
        return ProdutoConverter.convertEntityTo(produtoSalvo);
    }

    public List<Produto> salvarLista(List<Produto> novoProduto) {
        final List<ProdutoEntity> produtoEntityList = ProdutoConverter.convertProductTo(novoProduto);
        repository.saveAll(produtoEntityList);
        return ProdutoConverter.convertEntityTo(produtoEntityList);
    }

    public Produto buscaPorId(Long id) {
        final ProdutoEntity produtoSalvo = repository.findById(id)
                .orElseThrow(RuntimeException::new);
        return ProdutoConverter.convertEntityTo(produtoSalvo);
    }

    @Transactional(readOnly = true)
    public boolean isEmpty() {
        return repository.count() == 0;
    }


}
