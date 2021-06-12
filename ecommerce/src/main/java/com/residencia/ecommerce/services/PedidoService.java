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

//********************************************************************************************************************

    public Pedido update(Pedido pedido) {

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
      
//************************* Operações que o cliente ppoderá fazer após logado *****************************************

    public Pedido save(Pedido pedido) {
        Pedido novoPedido = pedidoRepository.save(pedido);
        if (novoPedido.getPedidoId() != null) {
            return novoPedido;
        } else {
            return null;
        }

    }

//*************************(fim) Operações que o cliente ppoderá fazer após logado (fim)*****************************************
}
