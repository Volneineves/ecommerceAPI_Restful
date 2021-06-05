package com.residencia.ecommerce.services;

import com.residencia.ecommerce.entities.Produto;

import com.residencia.ecommerce.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {


    @Autowired
    public ProdutoRepository produtoRepository;
//******************************************************************************************************************

    public Produto findById (Integer id){
        Produto produto = (Produto) produtoRepository.findById(id).get();
        return produto;
    }
//******************************************************************************************************************

    public List<Produto> findAll(Integer id){
        return produtoRepository.findAll();
    }

//******************************************************************************************************************


    public long count() {
        return produtoRepository.count();
    }

//******************************************************************************************************************

    public Produto save (Produto produto){
        Produto novoProduto = produtoRepository.save(produto);
        if(novoProduto.getProdutoId()!=null){
            return novoProduto;
        }
        else{ return null; }

    }
//********************************************************************************************************************

    public Produto update(Produto produto ){

        return produtoRepository.save(produto);
    }



//********************************************************************************************************************

    public boolean delete(Integer id) {
        if (id != null) {
            produtoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }



}
