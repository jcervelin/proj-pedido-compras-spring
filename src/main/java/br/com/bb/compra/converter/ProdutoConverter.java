package br.com.bb.compra.converter;

import br.com.bb.compra.model.Produto;
import br.com.bb.compra.model.entity.ProdutoEntity;

import java.math.BigDecimal;

public class ProdutoConverter {

    public static Produto convertTo(ProdutoEntity produto) {
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

    public static ProdutoEntity convertTo(Produto produto) {
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


}
