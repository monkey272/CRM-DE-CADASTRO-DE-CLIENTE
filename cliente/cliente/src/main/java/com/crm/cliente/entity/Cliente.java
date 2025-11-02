package com.crm.cliente.entity;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Cliente {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)

private int id;
private String nome;
private String email;
private String telefone;
private String endereco;


@OneToMany(mappedBy = "cliente", cascade= CascadeType.ALL, orphanRemoval = true)
private List<Interacao> interacoes = new ArrayList<>();

}