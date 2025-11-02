package com.crm.cliente.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.cliente.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    public static List<Cliente> listarTodos() {
        return null;
    }

}
