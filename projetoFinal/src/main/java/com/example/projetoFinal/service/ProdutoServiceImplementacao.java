package com.example.projetoFinal.service;

import com.example.projetoFinal.dto.AtualizarProdutoDTO;
import com.example.projetoFinal.dto.NovoProdutoDTO;
import com.example.projetoFinal.model.Produto;
import com.example.projetoFinal.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

//calsse pra implemwntar metodos da interface com logica de negocio

@Service
public class ProdutoServiceImplementacao implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @Override
    public Page<Produto> findAll(Pageable pageable) {
        return produtoRepository.findAll(pageable);
    }

    @Override
    public Produto findById(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    @Override
    public Produto save(NovoProdutoDTO novoProdutoDTO){
        Produto produto = new Produto();
        produto.setNome(novoProdutoDTO.getNome());
        produto.setPreco(novoProdutoDTO.getPreco());
        produto.setDescricao(novoProdutoDTO.getDescricao());
        produto.setCategoria(novoProdutoDTO.getCategoria());
        produto.setImagens(novoProdutoDTO.getImagens());

        return produtoRepository.save(produto);
    }

    @Override
    public Produto update(Long id, AtualizarProdutoDTO atualizarProdutoDTO) {
        Produto produto = produtoRepository.findById(id).orElse(null);
        if (produto == null) {
            return null;
        }
        produto.setNome(atualizarProdutoDTO.getNome());
        produto.setPreco(atualizarProdutoDTO.getPreco());
        produto.setDescricao(atualizarProdutoDTO.getDescricao());
        produto.setCategoria(atualizarProdutoDTO.getCategoria());
        produto.setImagens(atualizarProdutoDTO.getImagens());

        return produtoRepository.save(produto);
    }

    @Override
    public void delete(Long id){
        produtoRepository.deleteById(id);
    }
}



