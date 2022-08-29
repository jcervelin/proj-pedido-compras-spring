package br.com.bb.compra.controller;

import br.com.bb.compra.model.Cliente;
import br.com.bb.compra.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path ="clientes")
@Slf4j
@RequiredArgsConstructor
public class ClienteController {

    // Opcoes quando tenho mais de uma implementacao
    //1- @Qualifier(NOME DA CLASSE COM A PRIMEIRA LETRA MINUSCULA)
    //2- Incluir no construtor usando o mesmo nome da implementacao que voce  quer

    private final ClienteService clienteServiceImpl;

    @GetMapping
    public List<Cliente> clientes() {
        return clienteServiceImpl.getClientes();
    }

    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@Valid @RequestBody Cliente cliente) {
        clienteServiceImpl.salvarCliente(cliente);
        return ResponseEntity.ok(cliente);
    }

    //PUT para SALVAR
    // idempotente
    @PutMapping
    public ResponseEntity<Cliente> helloPut (@RequestBody Cliente cliente) {
        if (cliente.getId() == null) {
            throw new RuntimeException("Id é obrigatorio");
        }

       // final Cliente clienteAntigo = MAP.get(cliente.getId());

        // NIVEIS DE LOG
        //TRACE
        //DEBUG
        //INFO
        //WARN
        //ERROR

        log.info(" Estado atual {}", cliente);

        return ResponseEntity.ok().body(cliente);
    }

    @PatchMapping
    public ResponseEntity<Cliente> helloPatch (@RequestBody Cliente cliente) {
        if (cliente.getId() == null) {
            throw new RuntimeException("Id é obrigatorio");
        }
//
//        final Cliente clienteAntigo = MAP.get(cliente.getId());
//        // logar
//        MAP.put(cliente.getId(), mergearCliente(clienteAntigo, cliente));
        return ResponseEntity.ok().body(cliente);
    }

//    private Cliente mergearCliente(Cliente antigo, Cliente novo) {
//        if (novo.getIdade() != 0)
//            antigo.setIdade(novo.getIdade());
//
//        if (StringUtils.hasText(novo.getNome()))
//            antigo.setNome(novo.getNome());
//
//        return antigo;
//    }

}