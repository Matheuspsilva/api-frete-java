package com.example.apifrete.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Frete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private double valor;

    @Column(name = "dataEntrega")
    private LocalDate dataEntrega;
    private StatusFrete status;

    @ManyToOne
    private Remetente remetente;

    @ManyToOne
    private Destinatario destinatario;

    @ManyToOne
    private Transportadora transportadora;

    @ManyToOne
    private Rota rota;

    public Frete() {

    }

    public Frete(Long id, String descricao, double valor, LocalDate dataEntrega, StatusFrete status, Remetente remetente, Destinatario destinatario, Transportadora transportadora, Rota rota) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.dataEntrega = dataEntrega;
        this.status = status;
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.transportadora = transportadora;
        this.rota = rota;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public StatusFrete getStatus() {
        return status;
    }

    public void setStatus(StatusFrete status) {
        this.status = status;
    }

    public Remetente getRemetente() {
        return remetente;
    }

    public void setRemetente(Remetente remetente) {
        this.remetente = remetente;
    }

    public Destinatario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Destinatario destinatario) {
        this.destinatario = destinatario;
    }

    public Transportadora getTransportadora() {
        return transportadora;
    }

    public void setTransportadora(Transportadora transportadora) {
        this.transportadora = transportadora;
    }

    //toString separado por ; com quebra de linha a cada propriedade
    @Override
    public String toString() {
        return  "id: " + id + ";\n" + "descricao: " + descricao + ";\n" + "valor: " + valor + ";\n"
                + "dataEntrega: " + dataEntrega + ";\n" + "status: " + status + ";\n" + "remetente: " + remetente + ";\n"
                + "destinatario: " + destinatario + ";\n" + "transportadora: " + transportadora + ";\n" + "rota: " + rota + ";\n";
    }

    public String impressao() {
        return this.getClass().getName() + " " + super.toString();
    }
}
