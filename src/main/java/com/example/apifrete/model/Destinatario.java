package com.example.apifrete.model;

import jakarta.persistence.Entity;

@Entity
public class Destinatario extends Empresa {

    public Destinatario( Long id, String nome, String endereco, String telefone, String cnpj) {
        super( id, nome, endereco, telefone, cnpj);
    }

    public Destinatario() {

    }

    @Override
    public String impressao() {
        return this.getClass().getName() + " " + super.toString();
    }
}
