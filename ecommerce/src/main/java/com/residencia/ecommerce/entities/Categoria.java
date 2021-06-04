package com.residencia.ecommerce.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Categoria {
    private Integer categoriaId;
    private String nomeCategoria;
    private String descricaoCategoria;
    private Collection<Produto> produtosByCategoriaId;

    @Id
    @Column(name = "categoria_id")
    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    
    @Column(name = "nome_categoria")
    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    
    @Column(name = "descricao_categoria")
    public String getDescricaoCategoria() {
        return descricaoCategoria;
    }

    public void setDescricaoCategoria(String descricaoCategoria) {
        this.descricaoCategoria = descricaoCategoria;
    }

    @OneToMany(mappedBy = "categoriaByCategoriaId")
    public Collection<Produto> getProdutosByCategoriaId() {
        return produtosByCategoriaId;
    }

    public void setProdutosByCategoriaId(Collection<Produto> produtosByCategoriaId) {
        this.produtosByCategoriaId = produtosByCategoriaId;
    }
}
