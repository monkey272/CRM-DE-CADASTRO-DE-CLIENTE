package com.crm.cliente.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.cliente.entity.Interacao;
import com.crm.cliente.service.InteracaoService;

@RestController
@RequestMapping("/clientes/{clienteId}/interacoes")
public class InteracaoController {

    private final InteracaoService interacaoService;

    public InteracaoController(InteracaoService interacaoService) {
        this.interacaoService = interacaoService;
    }

    @GetMapping
    public List<Interacao> listar(@PathVariable Long clienteId) {
        return interacaoService.listarPorCliente(clienteId);
    }

    @PostMapping
    public Interacao salvar(@PathVariable Long clienteId, @RequestBody Interacao interacao) {
        return interacaoService.salvar(clienteId, interacao);
    }
}
