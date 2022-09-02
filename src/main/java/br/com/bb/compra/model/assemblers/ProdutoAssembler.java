package br.com.bb.compra.model.assemblers;

import br.com.bb.compra.controller.ProdutoController;
import br.com.bb.compra.model.Produto;
import br.com.bb.compra.model.entity.ProdutoEntity;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static br.com.bb.compra.converter.ProdutoConverter.convertEntityTo;

@Component
public class ProdutoAssembler extends RepresentationModelAssemblerSupport<ProdutoEntity, Produto> {
// passo para o generics a entidade 'Entity' e o produto dto


    public ProdutoAssembler() {
        // Classe do controller e o Dto
        super(ProdutoController.class, Produto.class);
    }

    @Override
    public Produto toModel(ProdutoEntity entity) {
        return convertEntityTo(entity);
    }
}
