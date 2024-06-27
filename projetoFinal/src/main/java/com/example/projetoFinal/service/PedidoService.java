package com.example.projetoFinal.service;

import com.example.projetoFinal.dto.CriaPedidoDTO;
import com.example.projetoFinal.dto.ItemCarrinhoDTO;
import com.example.projetoFinal.dto.ItemCarrinhoDTO;
import com.example.projetoFinal.dto.PedidoDTO;
import com.example.projetoFinal.dto.ProdutoDTO;
import com.example.projetoFinal.model.ItemCarrinho;
import com.example.projetoFinal.model.Pedido;
import com.example.projetoFinal.model.Produto;
import com.example.projetoFinal.repository.PedidoRepository;
import com.example.projetoFinal.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    private final ProdutoRepository produtoRepository;
    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoService (ProdutoRepository produtoRepository, PedidoRepository pedidoRepository) {
        this.produtoRepository = produtoRepository;
        this.pedidoRepository = pedidoRepository;
    }

    public PedidoDTO criarPedido(CriaPedidoDTO criaPedidoDTO){
        Pedido pedido = new Pedido();
        pedido.setEnderecoEntrega(criaPedidoDTO.getEnderecoEntrega());
        pedido.setFormaPagamento(criaPedidoDTO.getFormaPagamento());

        List<ItemCarrinho> itens = new ArrayList<>();

        for (ItemCarrinhoDTO itemCarrinhoDTO : criaPedidoDTO.getItens()) {
            Produto produto = produtoRepository.findById(itemCarrinhoDTO.getProduto().getId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

            ItemCarrinho itemCarrinho = new ItemCarrinho();
            itemCarrinho.setProduto(produto);
            itemCarrinho.setQuantidade(itemCarrinhoDTO.getQuantidade());

            itens.add(itemCarrinho);
        }

        pedido.setItens(itens);
        pedido = pedidoRepository.save(pedido);

        return new PedidoDTO(pedido);
    }

    public PedidoDTO obterPedido(Long id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        return new PedidoDTO(pedido);
    }

    public List<PedidoDTO> listarPedidos() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidos.stream().map(PedidoDTO::new).collect(Collectors.toList());
    }

    public PedidoDTO atualizarPedido(Long id, CriaPedidoDTO criaPedidoDTO) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        pedido.setEnderecoEntrega(criaPedidoDTO.getEnderecoEntrega());
        pedido.setFormaPagamento(criaPedidoDTO.getFormaPagamento());

        List<ItemCarrinho> itens = new ArrayList<>();

        for (ItemCarrinhoDTO itemCarrinhoDTO : criaPedidoDTO.getItens()) {
            Produto produto = produtoRepository.findById(itemCarrinhoDTO.getProduto().getId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

            ItemCarrinho itemCarrinho = new ItemCarrinho();
            itemCarrinho.setProduto(produto);
            itemCarrinho.setQuantidade(itemCarrinhoDTO.getQuantidade());

            itens.add(itemCarrinho);
        }

        pedido.setItens(itens);
        pedido = pedidoRepository.save(pedido);

        return new PedidoDTO(pedido);
    }
    public void deletarPedido(Long id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        pedidoRepository.delete(pedido);
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
