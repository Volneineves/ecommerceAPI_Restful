package com.residencia.ecommerce.vo;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public class PedidoVO {
    private Integer pedidoId;
    private Integer numeroPedido;
    private BigDecimal valorTotalPedido;
    private Date dataPedido;
    private Boolean status;
    private Integer clienteId;
    private List<ProdutoPedidoVO> produtoPedidosByPedidoId;

    public Integer getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Integer pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Integer getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(Integer numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public BigDecimal getValorTotalPedido() {
        return valorTotalPedido;
    }

    public void setValorTotalPedido(BigDecimal valorTotalPedido) {
        this.valorTotalPedido = valorTotalPedido;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public List<ProdutoPedidoVO> getProdutoPedidosByPedidoId() {
        return produtoPedidosByPedidoId;
    }

    public void setProdutoPedidosByPedidoId(List<ProdutoPedidoVO> produtoPedidosByPedidoId) {
        this.produtoPedidosByPedidoId = produtoPedidosByPedidoId;
    }
}
