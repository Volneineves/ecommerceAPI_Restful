package com.residencia.ecommerce.vo;

import com.residencia.ecommerce.entities.Categoria;
import com.residencia.ecommerce.entities.ProdutoPedido;

import java.math.BigDecimal;
import java.util.List;

public class ProdutoVO {
    private Integer produtoId;
    private String nomeProduto;
    private String descricaoProduto;
    private BigDecimal precoProduto;
    private Integer qtdEstoque;
    private String imagem;
    private Categoria categoria;
    private List<ProdutoPedido> produtoPedido;

    public Integer getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Integer produtoId) {
        this.produtoId = produtoId;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public BigDecimal getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(BigDecimal precoProduto) {
        this.precoProduto = precoProduto;
    }

    public Integer getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(Integer qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<ProdutoPedido> getProdutoPedido() {
        return produtoPedido;
    }

    public void setProdutoPedido(List<ProdutoPedido> produtoPedido) {
        this.produtoPedido = produtoPedido;
    }
}
