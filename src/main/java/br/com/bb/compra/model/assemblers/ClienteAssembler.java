package br.com.bb.compra.model.assemblers;

import br.com.bb.compra.controller.ClienteController;
import br.com.bb.compra.model.Cliente;
import br.com.bb.compra.model.entity.ClienteEntity;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

public class ClienteAssembler extends RepresentationModelAssemblerSupport<ClienteEntity, Cliente> {
    public ClienteAssembler() {
        super(ClienteController.class, Cliente.class);
    }

    @Override
    public Cliente toModel(ClienteEntity entity) {
        Cliente cliente = new Cliente();
        cliente.setId(entity.getId());
        return cliente;
    }
}
