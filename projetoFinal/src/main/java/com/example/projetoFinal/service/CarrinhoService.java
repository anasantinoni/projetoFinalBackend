package com.example.projetoFinal.service;

import com.example.projetoFinal.dto.AdicionarAoCarrinhoDTO;
import com.example.projetoFinal.dto.CarrinhoDTO;

public interface CarrinhoService {
    CarrinhoDTO adicionarAoCarrinho(AdicionarAoCarrinhoDTO adicionarAoCarrinhoDTO);
    CarrinhoDTO removerDoCarrinho(Long produtoId);
    CarrinhoDTO visualizarCarrinho();
}
