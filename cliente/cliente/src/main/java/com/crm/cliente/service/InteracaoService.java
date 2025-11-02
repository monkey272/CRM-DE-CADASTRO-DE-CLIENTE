package com.crm.cliente.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crm.cliente.entity.Cliente;
import com.crm.cliente.entity.Interacao;
import com.crm.cliente.repository.ClienteRepository;
import com.crm.cliente.repository.InteracaoRepository;

@Service
public class InteracaoService {

    private final InteracaoRepository interacaoRepository;
    private final ClienteRepository clienteRepository;

    public InteracaoService(InteracaoRepository interacaoRepository, ClienteRepository clienteRepository) {
        this.interacaoRepository = interacaoRepository;
        this.clienteRepository = clienteRepository;
    }

    public List<Interacao> listarPorCliente(Long clienteId) {
        return interacaoRepository.findByClienteId(clienteId);
    }

    public Interacao salvar(Long clienteId, Interacao interacao) {
        Cliente cliente = clienteRepository.findById(clienteId)
            .orElseThrow(() -> new RuntimeException("Cliente não encontrado com id: " + clienteId));
        
        interacao.setCliente(cliente); // vincula o cliente real do banco
        return interacaoRepository.save(interacao);
    }
}
