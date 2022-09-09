package br.com.bb.compra.service.impl;

import br.com.bb.compra.converter.ProdutoConverter;
import br.com.bb.compra.model.Produto;
import br.com.bb.compra.model.entity.ProdutoEntity;
import br.com.bb.compra.repository.ProdutoRepository;
import br.com.bb.compra.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository repository;

    @Override
    @PreAuthorize("hasAnyRole('ADMIN')")
    public Produto salvar(Produto novoProduto) {
        final ProdutoEntity produtoEntity = ProdutoConverter.convertProductTo(novoProduto);
        final ProdutoEntity produtoSalvo = repository.save(produtoEntity);
        return ProdutoConverter.convertEntityTo(produtoSalvo);
    }

    @Override
    public List<Produto> salvarLista(List<Produto> novoProduto) {
        final List<ProdutoEntity> produtoEntityList = ProdutoConverter.convertProductTo(novoProduto);
        final List<ProdutoEntity> produtoEntities = new ArrayList<>();
        final Iterable<ProdutoEntity> iterable = repository.saveAll(produtoEntityList);
        iterable.forEach(produtoEntities::add);
        return ProdutoConverter.convertEntityTo(produtoEntities);
    }

    @Override
    public Produto buscaPorId(Long id) {
        final ProdutoEntity produtoSalvo = repository.findById(id)
                .orElseThrow(RuntimeException::new);
        return ProdutoConverter.convertEntityTo(produtoSalvo);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isEmpty() {
        return repository.count() == 0;
    }

    @Override
    public Page<ProdutoEntity> listar(String filtro, Pageable pageable) {

        ProdutoEntity produtoFiltro = new ProdutoEntity();
        produtoFiltro.setNome(filtro);
        produtoFiltro.setDescricao(filtro);

        final ExampleMatcher exampleMatcher = ExampleMatcher
                .matchingAny()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        final Example<ProdutoEntity> entityExample = Example.of(produtoFiltro, exampleMatcher);
        return  repository.findAll(entityExample, pageable);
    }

    @Override
    @Cacheable(value = "produtos")
    public Page<ProdutoEntity> listar(Pageable pageable) {
        return  repository.findAll(pageable);
    }

}
