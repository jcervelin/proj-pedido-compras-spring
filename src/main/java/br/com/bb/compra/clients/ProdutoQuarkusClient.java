package br.com.bb.compra.clients;

import br.com.bb.compra.model.Produto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@FeignClient(
        name ="produtoApi",
        url = "${app.clients.produto.url}")
public interface ProdutoQuarkusClient {

    @PostMapping("/produtos")
    Produto salvar(@Valid @RequestBody Produto produto);

    @GetMapping("/produtos/{id}")
    Produto buscaPorId(@PathVariable Long id);

}
