package com.residencia.ecommerce.vo;

import com.residencia.ecommerce.entities.Pedido;
import com.residencia.ecommerce.entities.Produto;

import java.math.BigDecimal;

public class ProdutoPedidoVO {
    private Integer produtoPedidoId;
    private Integer qtdProdutoPedido;
    private BigDecimal precoProdutoPedido;
    private Produto produtoByProdutoId;
    private Pedido pedidoByPedidoId;

    public Integer getProdutoPedidoId() {
        return produtoPedidoId;
    }

    public void setProdutoPedidoId(Integer produtoPedidoId) {
        this.produtoPedidoId = produtoPedidoId;
    }

    public Integer getQtdProdutoPedido() {
        return qtdProdutoPedido;
    }

    public void setQtdProdutoPedido(Integer qtdProdutoPedido) {
        this.qtdProdutoPedido = qtdProdutoPedido;
    }

    public BigDecimal getPrecoProdutoPedido() {
        return precoProdutoPedido;
    }

    public void setPrecoProdutoPedido(BigDecimal precoProdutoPedido) {
        this.precoProdutoPedido = precoProdutoPedido;
    }

    public Produto getProdutoByProdutoId() {
        return produtoByProdutoId;
    }

    public void setProdutoByProdutoId(Produto produtoByProdutoId) {
        this.produtoByProdutoId = produtoByProdutoId;
    }

    public Pedido getPedidoByPedidoId() {
        return pedidoByPedidoId;
    }

    public void setPedidoByPedidoId(Pedido pedidoByPedidoId) {
        this.pedidoByPedidoId = pedidoByPedidoId;
    }
}
