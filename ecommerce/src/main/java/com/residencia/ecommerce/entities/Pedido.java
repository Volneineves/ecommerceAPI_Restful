package com.residencia.ecommerce.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Pedido {
    private Integer pedidoId;
    private Integer numeroPedido;
    private String listaProdutosDoPedido;
    private Object valorTotalPedido;
    private Date dataPedido;
    private Boolean status;
    private Integer clienteId;
    private Cliente clienteByClienteId;
    private Collection<ProdutoPedido> produtoPedidosByPedidoId;

    @Id
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
    public Object getValorTotalPedido() {
        return valorTotalPedido;
    }

    public void setValorTotalPedido(Object valorTotalPedido) {
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

    
    @Column(name = "cliente_id")
    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
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
    public Collection<ProdutoPedido> getProdutoPedidosByPedidoId() {
        return produtoPedidosByPedidoId;
    }

    public void setProdutoPedidosByPedidoId(Collection<ProdutoPedido> produtoPedidosByPedidoId) {
        this.produtoPedidosByPedidoId = produtoPedidosByPedidoId;
    }
}
