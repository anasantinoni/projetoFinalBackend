package com.example.projetoFinal.service;

import com.example.projetoFinal.dto.CriaPedidoDTO;
import com.example.projetoFinal.dto.ItemCarrinhoDTO;
import com.example.projetoFinal.dto.ItemCarrinhoDTO;
import com.example.projetoFinal.dto.PedidoDTO;
import com.example.projetoFinal.dto.ProdutoDTO;
import com.example.projetoFinal.model.ItemCarrinho;
import com.example.projetoFinal.model.Produto;
import com.example.projetoFinal.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public PedidoService (ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public PedidoDTO criarPedido(CriaPedidoDTO criaPedidoDTO){
        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.setEnderecoEntrega(criaPedidoDTO.getEnderecoEntrega());
        pedidoDTO.setFormaPagamento(criaPedidoDTO.getFormaPagamento());

        List<ItemCarrinhoDTO> itens = new ArrayList<>();

        for (ItemCarrinhoDTO itemCarrinho : criaPedidoDTO.getItens()) {
            Produto produto = produtoRepository.findById(itemCarrinho.getProduto().getId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

            ItemCarrinhoDTO itemDoPedido = new ItemCarrinhoDTO();
            itemDoPedido.setProduto(produto);
            itemDoPedido.setQuantidade(itemCarrinho.getQuantidade());

            itens.add(itemCarrinho);
        }

        pedidoDTO.setItens(itens);

        return pedidoDTO;
    }

    private ProdutoDTO convertToDto(Produto produto){
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setId(produto.getId());
        produtoDTO.setNome(produto.getNome());
        produtoDTO.setPreco(produtoDTO.getPreco());
        produtoDTO.setDescricao(produto.getDescricao());
        produtoDTO.setCategoria(produto.getCategoria());
        produtoDTO.setImagens(produto.getImagens());
        return produtoDTO;
    }

}
