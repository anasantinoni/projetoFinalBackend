package com.example.projetoFinal.dto;

import com.example.projetoFinal.model.Produto;

public class ProdutoDTO {
    private Long id;
    private String nome;
    private double preco;
    private String descricao;
    private String categoria;
    private String imagens;

    public Produto toProduto() {
        Produto produto = new Produto();
        produto.setId(this.id);
        produto.setNome(this.nome);
        produto.setPreco(this.preco);
        return produto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getImagens() {
        return imagens;
    }

    public void setImagens(String imagens) {
        this.imagens = imagens;
    }

}
