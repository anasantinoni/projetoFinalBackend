package com.example.projetoFinal.controller;

import com.example.projetoFinal.dto.CriaPedidoDTO;
import com.example.projetoFinal.dto.PedidoDTO;
import com.example.projetoFinal.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoDTO> criarPedido(@RequestBody CriaPedidoDTO criaPedidoDTO){
        PedidoDTO pedidoDTO = pedidoService.criarPedido(criaPedidoDTO);
        return ResponseEntity.ok(pedidoDTO);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> obterPedido(@PathVariable Long id){
        PedidoDTO pedidoDTO = pedidoService.obterPedido(id);
        return ResponseEntity.ok(pedidoDTO);
    }
    @GetMapping
    public ResponseEntity<List<PedidoDTO>> listarPedidos() {
        List<PedidoDTO> pedidos = pedidoService.listarPedidos();
        return ResponseEntity.ok(pedidos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDTO> atualizarPedido(@PathVariable Long id, @RequestBody CriaPedidoDTO criaPedidoDTO) {
        PedidoDTO pedidoDTO = pedidoService.atualizarPedido(id, criaPedidoDTO);
        return ResponseEntity.ok(pedidoDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id) {
        pedidoService.deletarPedido(id);
        return ResponseEntity.noContent().build();
    }
}
