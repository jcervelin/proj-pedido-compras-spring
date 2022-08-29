package br.com.bb.compra.service;


import br.com.bb.compra.model.Cliente;

import java.util.List;

public interface ClienteService {
    void salvarCliente(Cliente cliente);
    List<Cliente> getClientes();
}
