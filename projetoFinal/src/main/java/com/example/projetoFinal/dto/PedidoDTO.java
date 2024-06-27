package com.example.projetoFinal.dto;

import com.example.projetoFinal.model.ItemCarrinho;
import com.example.projetoFinal.model.Pedido;
import com.example.projetoFinal.model.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoDTO {
    private Long id;
    private List<ItemCarrinhoDTO> itens;
    private String enderecoEntrega;
    private String formaPagamento;

    public PedidoDTO(){}
    public PedidoDTO(Pedido pedido) {
        this.id = pedido.getId();
        this.enderecoEntrega = pedido.getEnderecoEntrega();
        this.formaPagamento = pedido.getFormaPagamento();
        this.itens = pedido.getItens().stream()
                .map(ItemCarrinhoDTO::new)
                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ItemCarrinhoDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemCarrinhoDTO> itens) {
        this.itens = itens;
    }

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
}


