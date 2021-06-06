package com.residencia.ecommerce.controllers;

import com.residencia.ecommerce.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Pedido")
public class PedidoController {

    @Autowired
    public PedidoService pedidoService;

}