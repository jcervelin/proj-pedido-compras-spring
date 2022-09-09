package br.com.bb.compra.controller;

import br.com.bb.compra.model.Produto;
import br.com.bb.compra.model.assemblers.ProdutoAssembler;
import br.com.bb.compra.model.entity.ProdutoEntity;
import br.com.bb.compra.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoServiceImpl;
    private final ProdutoAssembler produtoAssembler;
    private final PagedResourcesAssembler<ProdutoEntity> pagedResourcesAssembler;

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getId(@PathVariable Long id) {
        return ResponseEntity.ok(produtoServiceImpl.buscaPorId(id));
    }

    @PostMapping
    public ResponseEntity<Produto> salvar(@RequestBody @Valid Produto produto) {
        return ResponseEntity.ok(produtoServiceImpl.salvar(produto));
    }

    @GetMapping
    public ResponseEntity<PagedModel<Produto>> listar(String filtro, Pageable pageable) {
        final Page<ProdutoEntity> produtoEntities = produtoServiceImpl.listar(filtro, pageable);
        final PagedModel<Produto> produtos = pagedResourcesAssembler.toModel(produtoEntities, produtoAssembler);
        return ResponseEntity.ok(produtos);
    }

    @GetMapping(path = "/paginado")
    public PagedModel<Produto> listar(Pageable pageable) {
        final Page<ProdutoEntity> produtoEntities = produtoServiceImpl.listar(pageable);
        final PagedModel<Produto> produtos = pagedResourcesAssembler.toModel(produtoEntities, produtoAssembler);
        return produtos;
    }

}
