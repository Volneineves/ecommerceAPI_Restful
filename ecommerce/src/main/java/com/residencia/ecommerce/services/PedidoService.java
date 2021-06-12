package com.residencia.ecommerce.services;


import com.residencia.ecommerce.entities.Pedido;
import com.residencia.ecommerce.repositories.PedidoRepository;
import com.residencia.ecommerce.vo.PedidoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    public PedidoRepository pedidoRepository;

//******************************************************************************************************************

    public List<PedidoVO> findAllVO(Integer pagina, Integer qtdRegistros) throws Exception {
        Pageable page = null;
        List<Pedido> listPedido = null;
        List<Pedido> listPedidoComPaginacao = null;
        List<PedidoVO> listPedidoVO = new ArrayList<>();

        try {
            if (null != pagina && null != qtdRegistros) {

                page = PageRequest.of(pagina, qtdRegistros);
                listPedidoComPaginacao = pedidoRepository.findAll(page).getContent();

                for (Pedido lPedido : listPedidoComPaginacao) {
                    listPedidoVO.add(converteEntidadeParaVO(lPedido));
                }

            } else {
                listPedido = pedidoRepository.findAll();

                for (Pedido lPedido : listPedido) {
                    listPedidoVO.add(converteEntidadeParaVO(lPedido));
                }
            }
        } catch (Exception e) {
            throw new Exception("Não foi possível recuperar a lista de pedidos ::" + e.getMessage());
        }
        return listPedidoVO;
    }

    public Pedido updateLogado(Integer id, Pedido pedido) {
        Pedido newPedido = pedidoRepository.findById(id).get();
        updateDados(newPedido, pedido);
        return pedidoRepository.save(newPedido);
    }

    private void updateDados(Pedido newPedido, Pedido pedido) {

        newPedido.setPedidoId(pedido.getPedidoId());
        newPedido.setNumeroPedido(pedido.getNumeroPedido());
        newPedido.setValorTotalPedido(pedido.getValorTotalPedido());
        newPedido.setStatus(pedido.getStatus());
        newPedido.setDataPedido(pedido.getDataPedido());
        newPedido.setClienteByClienteId(pedido.getClienteByClienteId());
    }

    public void delete(Integer id) {
        if (id != null)
            pedidoRepository.deleteById(id);
    }

    private PedidoVO converteEntidadeParaVO(Pedido pedido) {
        PedidoVO pedidoVO = new PedidoVO();

        pedidoVO.setPedidoId(pedido.getPedidoId());
        pedidoVO.setNumeroPedido(pedido.getNumeroPedido());
        pedidoVO.setValorTotalPedido(pedido.getValorTotalPedido());
        pedidoVO.setStatus(pedido.getStatus());
        pedidoVO.setClienteId(pedido.getClienteByClienteId().getClienteId());

        return pedidoVO;
    }
}
