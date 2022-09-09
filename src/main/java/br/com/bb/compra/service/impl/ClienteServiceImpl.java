package br.com.bb.compra.service.impl;

import br.com.bb.compra.converter.ClienteConverter;
import br.com.bb.compra.model.Cliente;
import br.com.bb.compra.model.entity.ClienteEntity;
import br.com.bb.compra.model.enums.PerfilEnum;
import br.com.bb.compra.repository.ClienteRepository;
import br.com.bb.compra.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void salvarCliente(Cliente cliente) {

        if (Objects.isNull(cliente.getId())) {
            cliente.setSenha(passwordEncoder.encode(cliente.getSenha()));
        }

        cliente.setPerfil(PerfilEnum.CLIENTE);

        clienteRepository.save(ClienteConverter.convertDtoTo(cliente));
    }

    @Override
    public List<Cliente> getClientes() {
        return convert(clienteRepository.findAll());
    }

    private Cliente convert(ClienteEntity entity) {
        return Cliente.builder()
                .id(entity.getId())
                .cpf(entity.getCpf())
                .nome(entity.getNome())
                .email(entity.getEmail())
                .build();
    }

    private List<Cliente> convert(List<ClienteEntity> entities) {
        return entities.stream().map(this::convert)
                .collect(Collectors.toList());
    }
}
