package com.example.projetoFinal.controller;

import com.example.projetoFinal.dto.AtualizarProdutoDTO;
import com.example.projetoFinal.dto.NovoProdutoDTO;
import com.example.projetoFinal.dto.ProdutoDTO;
import com.example.projetoFinal.model.Produto;
import com.example.projetoFinal.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;



    @PostMapping
    public ResponseEntity<ProdutoDTO> createProduto(@RequestBody NovoProdutoDTO novoProdutoDTO) {
        Produto produto = produtoService.save(novoProdutoDTO);
        ProdutoDTO produtoDTO = convertToDto(produto);
        return ResponseEntity.ok(produtoDTO);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> updateProduto(@PathVariable Long id, @RequestBody AtualizarProdutoDTO atualizarProdutoDTO) {
        Produto produto = produtoService.update(id, atualizarProdutoDTO);
        ProdutoDTO produtoDTO = convertToDto(produto);
        return ResponseEntity.ok(produtoDTO);
    }

    @GetMapping
    public ResponseEntity<Page<ProdutoDTO>> getAllProdutos(Pageable pageable) {
        Page<Produto> produtos = produtoService.findAll(pageable);
        Page<ProdutoDTO> produtoDTOs = produtos.map(this::convertToDto);
        return ResponseEntity.ok(produtoDTOs);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    private ProdutoDTO convertToDto(Produto produto) {
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setId(produto.getId());
        produtoDTO.setNome(produto.getNome());
        produtoDTO.setPreco(produto.getPreco());
        produtoDTO.setDescricao(produto.getDescricao());
        produtoDTO.setCategoria(produto.getCategoria());
        produtoDTO.setImagens(produto.getImagens());
        return produtoDTO;
    }

    

}







