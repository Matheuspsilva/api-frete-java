package com.example.apifrete.model;

import jakarta.persistence.Entity;

@Entity
public class Transportadora extends Empresa{

    public Transportadora() {
    }

    public Transportadora(Long id, String nome, String endereco, String telefone, String cnpj) {
        super(id, nome, endereco, telefone, cnpj);
    }

    @Override
    public String impressao() {
        return this.getClass().getName() + " " + super.toString();
    }

}
