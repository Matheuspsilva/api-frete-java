package com.example.apifrete.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Remetente extends Empresa{
    public Remetente( Long id, String nome, String endereco, String telefone, String cnpj) {
        super( id, nome, endereco, telefone, cnpj);
    }

    public Remetente() {

    }

    @Override
    public String impressao() {
        return this.getClass().getName() + " " + super.toString();
    }

}
