package com.crm.cliente.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crm.cliente.entity.Interacao;

@Repository
public interface InteracaoRepository extends JpaRepository<Interacao, Long> {

    // Busca todas as interações de um cliente pelo ID
    List<Interacao> findByClienteId(Long clienteId);
}
