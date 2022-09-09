package br.com.bb.compra.security;

import br.com.bb.compra.converter.ClienteConverter;
import br.com.bb.compra.model.Cliente;
import br.com.bb.compra.model.entity.ClienteEntity;
import br.com.bb.compra.repository.ClienteRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserDetailsService {

    final ClienteRepository clienteRepository;

    public UserServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        ClienteEntity entity = clienteRepository.findByEmail(email);

        if (Objects.isNull(entity)) {
            throw new UsernameNotFoundException(email);
        }

        final Cliente cliente = ClienteConverter.convertEntityTo(entity);

        return new UserPrincipalDetails(cliente);
    }

}
