package com.residencia.ecommerce.controllers;

import com.residencia.ecommerce.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Categoria")
public class CategoriaController {

    @Autowired
    public CategoriaService categoriaService;

}