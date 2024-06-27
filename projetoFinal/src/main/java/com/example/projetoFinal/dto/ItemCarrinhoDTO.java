package com.example.projetoFinal.dto;

import com.example.projetoFinal.model.ItemCarrinho;
import com.example.projetoFinal.model.Produto;
import jakarta.persistence.*;


public class ItemCarrinhoDTO {

    private ProdutoDTO produto;
    private Long id;
    private int quantidade;

    public ItemCarrinhoDTO() {
    }

    public ItemCarrinhoDTO(ItemCarrinho itemCarrinho) {
        this.id = itemCarrinho.getId();
        this.produto = new ProdutoDTO(itemCarrinho.getProduto());
        this.quantidade = itemCarrinho.getQuantidade();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProdutoDTO getProduto() {
        return produto;
    }

    public void setProduto(ProdutoDTO produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
