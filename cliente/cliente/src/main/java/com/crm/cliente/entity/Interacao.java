package com.crm.cliente.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Interacao {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private int id;
    private String tipo; //Tipo da chamada (se é ligação, reunião, Email)
    private String descricao;

    private LocalDateTime dataHora;
    
    @ManyToOne
    @JoinColumn(name="cliente_id", nullable=false)
    private Cliente cliente;

    public void setCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
   
    
    







    









}
