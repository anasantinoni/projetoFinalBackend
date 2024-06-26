package com.example.projetoFinal.service;

import com.example.projetoFinal.dto.AdicionarAoCarrinhoDTO;
import com.example.projetoFinal.dto.Carrinho;
import org.springframework.stereotype.Service;

@Service
public class CarrinhoServiceImplementacao implements CarrinhoService {

    @Override
    public Carrinho adicionarAoCarrinho(AdicionarAoCarrinhoDTO adicionarAoCarrinhoDTO){
        return new Carrinho();
    }

    @Override
    public Carrinho removerDoCarrinho(Long produtoId){
        return new Carrinho();
    }

    @Override
    public Carrinho visualizarCarrinho(){
        return new Carrinho();
    }
}
