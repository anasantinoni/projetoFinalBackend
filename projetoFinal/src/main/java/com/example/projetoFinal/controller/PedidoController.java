package com.example.projetoFinal.controller;

import com.example.projetoFinal.dto.CriaPedidoDTO;
import com.example.projetoFinal.dto.PedidoDTO;
import com.example.projetoFinal.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
