package com.example.projetoFinal.service;

import com.example.projetoFinal.dto.AdicionarAoCarrinhoDTO;
import com.example.projetoFinal.dto.Carrinho;

public interface CarrinhoService {
    Carrinho adicionarAoCarrinho(AdicionarAoCarrinhoDTO adicionarAoCarrinhoDTO);
    Carrinho removerDoCarrinho(Long produtoId);
    Carrinho visualizarCarrinho();
}
