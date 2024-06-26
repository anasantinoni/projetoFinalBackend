package com.example.projetoFinal.service;

import com.example.projetoFinal.dto.AtualizarProdutoDTO;
import com.example.projetoFinal.dto.NovoProdutoDTO;
import com.example.projetoFinal.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProdutoService {
    List<Produto> findAll();
    Page<Produto> findAll(Pageable pageable);
    Produto findById(Long id);
    Produto save(NovoProdutoDTO novoProdutoDTO);
    void delete(Long id);
    Produto update(Long id, AtualizarProdutoDTO atualizarProdutoDTO);
}
