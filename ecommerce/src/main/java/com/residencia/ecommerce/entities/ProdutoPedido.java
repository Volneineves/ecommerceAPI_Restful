package com.residencia.ecommerce.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "produto_pedido", schema = "public", catalog = "ecommerce_api_grupo7")
public class ProdutoPedido {
    private Integer produtoPedidoId;
    private Integer qtdProdutoPedido;
    private BigDecimal precoProdutoPedido;
    private Produto produtoByProdutoId;
    private Pedido pedidoByPedidoId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produto_pedido_id")
    public Integer getProdutoPedidoId() {
        return produtoPedidoId;
    }

    public void setProdutoPedidoId(Integer produtoPedidoId) {
        this.produtoPedidoId = produtoPedidoId;
    }
    
    @Column(name = "qtd_produto_pedido")
    public Integer getQtdProdutoPedido() {
        return qtdProdutoPedido;
    }

    public void setQtdProdutoPedido(Integer qtdProdutoPedido) {
        this.qtdProdutoPedido = qtdProdutoPedido;
    }

    @Column(name = "preco_produto_pedido")
    public BigDecimal getPrecoProdutoPedido() {
        return precoProdutoPedido;
    }

    public void setPrecoProdutoPedido(BigDecimal precoProdutoPedido) {
        this.precoProdutoPedido = precoProdutoPedido;
    }

    @ManyToOne
    @JoinColumn(name = "produto_id", referencedColumnName = "produto_id", nullable = false)
    public Produto getProdutoByProdutoId() {
        return produtoByProdutoId;
    }

    public void setProdutoByProdutoId(Produto produtoByProdutoId) {
        this.produtoByProdutoId = produtoByProdutoId;
    }

    @ManyToOne
    @JoinColumn(name = "pedido_id", referencedColumnName = "pedido_id", nullable = false)
    public Pedido getPedidoByPedidoId() {
        return pedidoByPedidoId;
    }

    public void setPedidoByPedidoId(Pedido pedidoByPedidoId) {
        this.pedidoByPedidoId = pedidoByPedidoId;
    }
}
