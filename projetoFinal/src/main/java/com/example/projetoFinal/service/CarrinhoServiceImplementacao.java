package com.example.projetoFinal.service;

import com.example.projetoFinal.dto.AdicionarAoCarrinhoDTO;
import com.example.projetoFinal.dto.CarrinhoDTO;
import org.springframework.stereotype.Service;

@Service
public class CarrinhoServiceImplementacao implements CarrinhoService {

    @Override
    public CarrinhoDTO adicionarAoCarrinho(AdicionarAoCarrinhoDTO adicionarAoCarrinhoDTO){
        return new CarrinhoDTO();
    }

    @Override
    public CarrinhoDTO removerDoCarrinho(Long produtoId){
        return new CarrinhoDTO();
    }

    @Override
    public CarrinhoDTO visualizarCarrinho(){
        return new CarrinhoDTO();
    }
}
