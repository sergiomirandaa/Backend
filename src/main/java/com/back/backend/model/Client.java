package com.back.backend.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String nome;
    public String tipo;
    public char genero;
    public String dataNascimento;
    public String observacao;
    public boolean inativo;
}


