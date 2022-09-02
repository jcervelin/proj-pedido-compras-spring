package br.com.bb.compra.service.impl;

import br.com.bb.compra.converter.ProdutoConverter;
import br.com.bb.compra.model.Produto;
import br.com.bb.compra.model.assemblers.ProdutoAssembler;
import br.com.bb.compra.model.entity.ProdutoEntity;
import br.com.bb.compra.repository.ProdutoRepository;
import br.com.bb.compra.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository repository;

    private final ProdutoAssembler produtoAssembler;
    private final PagedResourcesAssembler<ProdutoEntity> pagedResourcesAssembler;

    @Override
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
    public PagedModel<Produto> listar(String filtro, Pageable pageable) {

        ProdutoEntity produtoFiltro = new ProdutoEntity();
        produtoFiltro.setNome(filtro);
        produtoFiltro.setDescricao(filtro);

        final ExampleMatcher exampleMatcher = ExampleMatcher
                .matchingAny()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        final Example<ProdutoEntity> entityExample = Example.of(produtoFiltro, exampleMatcher);
        final Page<ProdutoEntity> produtoEntities = repository.findAll(entityExample, pageable);

        return pagedResourcesAssembler.toModel(produtoEntities, produtoAssembler);
    }

    @Override
    public PagedModel<Produto> listar(Pageable pageable) {
        final Page<ProdutoEntity> produtoEntities = repository.findAll(pageable);
        final PagedModel<Produto> produtos = pagedResourcesAssembler.toModel(produtoEntities, produtoAssembler);
        return produtos;
    }


}
