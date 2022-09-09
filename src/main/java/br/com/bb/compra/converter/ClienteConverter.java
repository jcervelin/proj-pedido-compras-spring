package br.com.bb.compra.converter;

import br.com.bb.compra.model.Cliente;
import br.com.bb.compra.model.entity.ClienteEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteConverter {

    public static Cliente convertEntityTo(ClienteEntity clienteEntity) {
        Cliente cliente = new Cliente();
        cliente.setId(clienteEntity.getId());
        cliente.setCpf(clienteEntity.getCpf());
        cliente.setEmail(clienteEntity.getEmail());
        cliente.setNome(clienteEntity.getNome());
        cliente.setSenha(clienteEntity.getSenha());
        cliente.setPerfil(clienteEntity.getPerfil());
        return cliente;
    }

    public static ClienteEntity convertDtoTo(Cliente cliente) {
        ClienteEntity entity = new ClienteEntity();
        entity.setId(cliente.getId());
        entity.setCpf(cliente.getCpf());
        entity.setEmail(cliente.getEmail());
        entity.setNome(cliente.getNome());
        entity.setSenha(cliente.getSenha());
        entity.setPerfil(cliente.getPerfil());
        return entity;
    }

    public static List<Cliente> convertEntityTo(List<ClienteEntity> entities) {
        return entities.stream().map(ClienteConverter::convertEntityTo)
                .collect(Collectors.toList());
    }

}
