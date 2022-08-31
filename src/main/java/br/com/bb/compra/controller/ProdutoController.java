package br.com.bb.compra.controller;

import br.com.bb.compra.model.Produto;
import br.com.bb.compra.service.ProdutoService;
import lombok.RequiredArgsConstructor;
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

    private final ProdutoService produtoService;

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getId(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.buscaPorId(id));
    }

    @PostMapping
    public ResponseEntity<Produto> salvar(@RequestBody @Valid Produto produto) {
        return ResponseEntity.ok(produtoService.salvar(produto));
    }

}
