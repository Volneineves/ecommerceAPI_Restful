package com.residencia.ecommerce.controllers;

import com.residencia.ecommerce.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Produto")
public class ProdutoController {

    @Autowired
    public ProdutoService produtoService;

}