package com.example.projetoFinal.dto;

import java.util.List;

public class CarrinhoDTO {
    private List<ItemCarrinhoDTO> itens;

    public List<ItemCarrinhoDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemCarrinhoDTO> itens) {
        this.itens = itens;
    }

}
