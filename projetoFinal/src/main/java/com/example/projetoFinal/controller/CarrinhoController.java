package com.example.projetoFinal.controller;

import com.example.projetoFinal.dto.AdicionarAoCarrinhoDTO;
import com.example.projetoFinal.dto.CarrinhoDTO;
import com.example.projetoFinal.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    private final CarrinhoService carrinhoService;

    @Autowired
    public CarrinhoController(CarrinhoService carrinhoService){
        this.carrinhoService = carrinhoService;
    }

    @PostMapping
    public CarrinhoDTO adicionarAoCarrinho(@RequestBody AdicionarAoCarrinhoDTO adicionarAoCarrinhoDTO) {
        return carrinhoService.adicionarAoCarrinho(adicionarAoCarrinhoDTO);
    }

    @DeleteMapping("/{produtoId}")
    public CarrinhoDTO removerDoCarrinho(@PathVariable Long produtoId) {
        return carrinhoService.removerDoCarrinho(produtoId);
    }

    @GetMapping
    public CarrinhoDTO visualizarCarrinho() {
        return carrinhoService.visualizarCarrinho();
    }
}
