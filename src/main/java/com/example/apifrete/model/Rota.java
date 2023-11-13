package com.example.apifrete.model;

import jakarta.persistence.*;

@Entity
public class Rota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float distancia;

    private String nome;

    private String enderecoOrigem;

    private String enderecoDestino;

    public Rota() {
    }

    public Rota(Long id, String nome, Float distancia, String enderecoOrigem, String enderecoDestino) {
        this.id = id;
        this.distancia = distancia;
        this.nome = nome;
        this.enderecoOrigem = enderecoOrigem;
        this.enderecoDestino = enderecoDestino;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getDistancia() {
        return distancia;
    }

    public void setDistancia(Float distancia) {
        this.distancia = distancia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEnderecoOrigem() {
        return enderecoOrigem;
    }

    public void setEnderecoOrigem(String enderecoOrigem) {
        this.enderecoOrigem = enderecoOrigem;
    }

    public String getEnderecoDestino() {
        return enderecoDestino;
    }

    public void setEnderecoDestino(String enderecoDestino) {
        this.enderecoDestino = enderecoDestino;
    }

    public String impressao() {
        return this.getClass().getName() + " " + super.toString();
    }
}
