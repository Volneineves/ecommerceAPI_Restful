package com.residencia.ecommerce.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Entity
public class Pedido {
    private Integer pedidoId;
    private Integer numeroPedido;
    private String listaProdutosDoPedido;
    private BigDecimal valorTotalPedido;
    private Date dataPedido;
    private Boolean status;
    private Cliente clienteByClienteId;
    private List<ProdutoPedido> produtoPedidosByPedidoId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pedido_id")
    public Integer getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Integer pedidoId) {
        this.pedidoId = pedidoId;
    }


    @Column(name = "numero_pedido")
    public Integer getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(Integer numeroPedido) {
        this.numeroPedido = numeroPedido;
    }


    @Column(name = "lista_produtos_do_pedido")
    public String getListaProdutosDoPedido() {
        return listaProdutosDoPedido;
    }

    public void setListaProdutosDoPedido(String listaProdutosDoPedido) {
        this.listaProdutosDoPedido = listaProdutosDoPedido;
    }


    @Column(name = "valor_total_pedido")
    public BigDecimal getValorTotalPedido() {
        return valorTotalPedido;
    }

    public void setValorTotalPedido(BigDecimal valorTotalPedido) {
        this.valorTotalPedido = valorTotalPedido;
    }


    @Column(name = "data_pedido")
    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    @Column(name = "status")
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "cliente_id", nullable = false)
    public Cliente getClienteByClienteId() {
        return clienteByClienteId;
    }

    public void setClienteByClienteId(Cliente clienteByClienteId) {
        this.clienteByClienteId = clienteByClienteId;
    }

    @OneToMany(mappedBy = "pedidoByPedidoId")
    public List<ProdutoPedido> getProdutoPedidosByPedidoId() {
        return produtoPedidosByPedidoId;
    }

    public void setProdutoPedidosByPedidoId(List<ProdutoPedido> produtoPedidosByPedidoId) {
        this.produtoPedidosByPedidoId = produtoPedidosByPedidoId;
    }
}
