package br.com.bb.compra.service.impl;

import br.com.bb.compra.model.PedidoRequestDto;
import br.com.bb.compra.model.PedidoResponseDto;
import br.com.bb.compra.security.JwtUtils;
import br.com.bb.compra.service.PedidoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PedidoServiceImpl implements PedidoService {

    @Override
    public PedidoResponseDto realizarPedido(PedidoRequestDto pedido) {
        final String email = JwtUtils.getEmailFromContext();

        log.info("O usuario {} iniciou pedido {}", email, pedido);
        return null;
    }
}
