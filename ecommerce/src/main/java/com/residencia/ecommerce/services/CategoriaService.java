package com.residencia.ecommerce.services;

import com.residencia.ecommerce.entities.Categoria;
import com.residencia.ecommerce.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
    public class CategoriaService {

@Autowired
    public CategoriaRepository categoriaRepository;
//******************************************************************************************************************

    public Categoria findById (Integer id){
        Categoria categoria = categoriaRepository.findById(id).get();
    return categoria;
}
//******************************************************************************************************************

    public List<Categoria> findAll( Integer id){
        return categoriaRepository.findAll();
    }

//******************************************************************************************************************


    public long count() {
        return categoriaRepository.count();
    }

//******************************************************************************************************************

    public Categoria save (Categoria categoria){
        Categoria novaCategoria = categoriaRepository.save(categoria);
        if(novaCategoria.getCategoriaId()!=null){
            return novaCategoria;
        }
        else{ return null; }

    }
//********************************************************************************************************************

    public Categoria update(Categoria categoria ){

        return categoriaRepository.save(categoria);
    }
//********************************************************************************************************************

    public boolean delete(Integer id) {
        if (id != null) {
            categoriaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }






}
