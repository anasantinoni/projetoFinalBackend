package com.example.projetoFinal.dto;

import com.example.projetoFinal.model.ItemCarrinho;

import java.util.List;

public class CriaPedidoDTO {
    private String enderecoEntrega;
    private String formaPagamento;
    private List<ItemCarrinhoDTO> itens;


    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public List<ItemCarrinhoDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemCarrinhoDTO> itens) {
        this.itens = itens;
    }
}
