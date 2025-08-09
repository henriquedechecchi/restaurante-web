package com.restaurante.restaurante_web.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "comandas")
public class Comanda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Mesa mesa;

    @ManyToOne
    private Cliente cliente;

    @ManyToMany
    private List<Bebida> bebidas = new ArrayList<>();

    @ManyToMany
    private List<Refeicao> refeicoes = new ArrayList<>();

    private boolean fechada;

    public Comanda() {}

    public Comanda(Mesa mesa, Cliente cliente) {
        this.mesa = mesa;
        this.cliente = cliente;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Mesa getMesa() { return mesa; }
    public void setMesa(Mesa mesa) { this.mesa = mesa; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public List<Bebida> getBebidas() { return bebidas; }
    public void setBebidas(List<Bebida> bebidas) { this.bebidas = bebidas; }

    public List<Refeicao> getRefeicoes() { return refeicoes; }
    public void setRefeicoes(List<Refeicao> refeicoes) { this.refeicoes = refeicoes; }

    public boolean isFechada() { return fechada; }
    public void setFechada(boolean fechada) { this.fechada = fechada; }
}
