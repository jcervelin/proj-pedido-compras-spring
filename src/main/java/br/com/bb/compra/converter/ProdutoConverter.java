package br.com.bb.compra.converter;

import br.com.bb.compra.model.Produto;
import br.com.bb.compra.model.entity.ProdutoEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ProdutoConverter {

    public static Produto convertEntityTo(ProdutoEntity produto) {
        Produto p = new Produto();
        p.setDesconto(String.valueOf(produto.getDesconto()));
        p.setDescricao(produto.getDescricao());
        p.setEstoque(produto.getEstoque());
        p.setId(produto.getId());
        p.setFoto(produto.getFoto());
        p.setNome(produto.getNome());
        p.setPreco(String.valueOf((p.getPreco())));
        return p;
    }

    public static List<Produto> convertEntityTo(List<ProdutoEntity> produtos) {
        return produtos.stream()
                .map(ProdutoConverter::convertEntityTo)
                .collect(Collectors.toList());
    }
    public static ProdutoEntity convertProductTo(Produto produto) {
        ProdutoEntity p = new ProdutoEntity();
        p.setDesconto(new BigDecimal(produto.getDesconto()));
        p.setDescricao(produto.getDescricao());
        p.setEstoque(produto.getEstoque());
        p.setId(produto.getId());
        p.setFoto(produto.getFoto());
        p.setNome(produto.getNome());
        p.setPreco(new BigDecimal(produto.getPreco()));
        return p;
    }

    public static List<ProdutoEntity> convertProductTo(List<Produto> produtos) {
        return produtos.stream()
                .map(ProdutoConverter::convertProductTo)
                .collect(Collectors.toList());
    }


}
