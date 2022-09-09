package br.com.bb.compra.service;

import br.com.bb.compra.model.PedidoRequestDto;
import br.com.bb.compra.model.PedidoResponseDto;

public interface PedidoService {

    PedidoResponseDto realizarPedido(PedidoRequestDto pedido);

}
