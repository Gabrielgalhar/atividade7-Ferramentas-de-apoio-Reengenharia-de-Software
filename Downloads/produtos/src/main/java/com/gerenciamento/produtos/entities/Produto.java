package com.gerenciamento.produtos.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "/produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    private  Double preço;
    private Integer quantidadeEmEstoque;

    public Produto(){
    }

    public Produto(long id, String nome, Double preço, Integer quantidadeEmEstoque) {
        this.id = id;
        this.nome = nome;
        this.preço = preço;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreço() {
        return preço;
    }

    public void setPreço(Double preço) {
        this.preço = preço;
    }

    public Integer getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(Integer quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }
}
