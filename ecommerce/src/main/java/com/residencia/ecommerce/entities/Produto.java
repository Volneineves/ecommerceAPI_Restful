package com.residencia.ecommerce.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Produto {
    private Integer produtoId;
    private String nomeProduto;
    private String descricaoProduto;
    private Object precoProduto;
    private Integer qtdEstoque;
    private Date dataCadastroProduto;
    private byte[] imagem;
    private Categoria categoriaByCategoriaId;
    private Collection<ProdutoPedido> produtoPedidosByProdutoId;

    @Id
    @Column(name = "produto_id")
    public Integer getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Integer produtoId) {
        this.produtoId = produtoId;
    }

    
    @Column(name = "nome_produto")
    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    
    @Column(name = "descricao_produto")
    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    
    @Column(name = "preco_produto")
    public Object getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(Object precoProduto) {
        this.precoProduto = precoProduto;
    }

    
    @Column(name = "qtd_estoque")
    public Integer getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(Integer qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    
    @Column(name = "data_cadastro_produto")
    public Date getDataCadastroProduto() {
        return dataCadastroProduto;
    }

    public void setDataCadastroProduto(Date dataCadastroProduto) {
        this.dataCadastroProduto = dataCadastroProduto;
    }

    
    @Column(name = "imagem")
    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    @ManyToOne
    @JoinColumn(name = "categoria_id", referencedColumnName = "categoria_id", nullable = false)
    public Categoria getCategoriaByCategoriaId() {
        return categoriaByCategoriaId;
    }

    public void setCategoriaByCategoriaId(Categoria categoriaByCategoriaId) {
        this.categoriaByCategoriaId = categoriaByCategoriaId;
    }

    @OneToMany(mappedBy = "produtoByProdutoId")
    public Collection<ProdutoPedido> getProdutoPedidosByProdutoId() {
        return produtoPedidosByProdutoId;
    }

    public void setProdutoPedidosByProdutoId(Collection<ProdutoPedido> produtoPedidosByProdutoId) {
        this.produtoPedidosByProdutoId = produtoPedidosByProdutoId;
    }
}
