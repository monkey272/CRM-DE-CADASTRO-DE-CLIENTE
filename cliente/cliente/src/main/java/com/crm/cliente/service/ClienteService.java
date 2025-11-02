package com.crm.cliente.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.cliente.entity.Cliente;
import com.crm.cliente.repository.ClienteRepository;

@Service

public class ClienteService {

@Autowired

private ClienteRepository clienteRepository;

public List<Cliente> listarTodos(){
    return clienteRepository.findAll();
}
public Cliente salvar(Cliente cliente){
    return clienteRepository.save(cliente);
}
public Optional<Cliente> BuscarPorId(Long id){
    return clienteRepository.findById(id);
}
public void deletar(Long id){
     clienteRepository.deleteById(id);
}
   public void deletarTodos() {
        clienteRepository.deleteAll();
    }



}
