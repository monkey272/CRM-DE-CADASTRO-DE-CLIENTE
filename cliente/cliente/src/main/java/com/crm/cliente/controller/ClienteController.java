package com.crm.cliente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.cliente.entity.Cliente;
import com.crm.cliente.service.ClienteService;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "http://localhost:3000")

public class ClienteController {
    
@Autowired
private ClienteService clienteService;

@GetMapping
public List<Cliente> lististarTodos(){
    return clienteService.listarTodos();
}
@PostMapping
public Cliente criarCliente(@RequestBody Cliente cliente){
    return clienteService.salvar(cliente);
}
@GetMapping("/{id}")
public ResponseEntity<Cliente> buscar(@PathVariable Long id){
    return clienteService.BuscarPorId(id)
    .map(ResponseEntity::ok)
    .orElse(ResponseEntity.notFound().build());
}
@DeleteMapping("/{id}")
public void deletar(@PathVariable Long id){
     clienteService.deletar(id);
}
@DeleteMapping("/deletar-todos")
public void deletarTodos() {
    clienteService.deletarTodos();
}


}