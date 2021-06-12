package com.residencia.ecommerce.controllers;

import com.residencia.ecommerce.entities.Pedido;
import com.residencia.ecommerce.services.PedidoService;
import com.residencia.ecommerce.vo.PedidoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Pedido")
public class PedidoController {

    @Autowired
    public PedidoService pedidoService;

    @GetMapping("/pedido-por-nome")
    public ResponseEntity<List<PedidoVO>> findAllVO(
            @RequestParam(required = false) Integer pagina,
            @RequestParam(required = false) Integer qtdRegistros)
            throws Exception {

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(pedidoService.findAllVO(pagina,
                qtdRegistros), headers, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pedido> delete(@PathVariable Integer id) {
        try {
            pedidoService.delete(id);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}