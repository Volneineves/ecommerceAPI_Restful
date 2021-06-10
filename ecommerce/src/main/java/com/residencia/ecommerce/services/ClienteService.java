package com.residencia.ecommerce.services;

import com.residencia.ecommerce.entities.Cliente;
import com.residencia.ecommerce.entities.Pedido;
import com.residencia.ecommerce.entities.Produto;
import com.residencia.ecommerce.repositories.ClienteRepository;
import com.residencia.ecommerce.repositories.PedidoRepository;
import com.residencia.ecommerce.vo.ClienteVO;
import com.residencia.ecommerce.vo.PedidoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    public ClienteRepository clienteRepository;

    @Autowired
    public PedidoRepository pedidoRepository;
//******************************************************************************************************************

    public ClienteVO findById (Integer id){
        Cliente cliente = clienteRepository.findById(id).get();
        return converteEntidadeParaVO(cliente);
    }
//******************************************************************************************************************

    public List<ClienteVO> findAllVO(Integer pagina, Integer qtdRegistros) throws Exception {
        Pageable page = null;
        List<Cliente> listCliente = null;
        List<Cliente> listClienteComPaginacao = null;
        List<ClienteVO> listClienteVO = new ArrayList<>();

        try {
            if (null != pagina && null != qtdRegistros) {

                page = PageRequest.of(pagina, qtdRegistros);
                listClienteComPaginacao = clienteRepository.findAll(page).getContent();

                for (Cliente lCliente : listClienteComPaginacao) {
                    listClienteVO.add(converteEntidadeParaVO(lCliente));
                }

            } else {
                listCliente = clienteRepository.findAll();

                for (Cliente lCliente : listCliente) {
                    listClienteVO.add(converteEntidadeParaVO(lCliente));
                }
            }
        } catch (Exception e) {
            throw new Exception("Não foi possível recuperar a lista de pedidos ::" + e.getMessage());
        }
        return listClienteVO;
    }

//******************************************************************************************************************


    public long count() {
        return clienteRepository.count();
    }

//******************************************************************************************************************

    public ClienteVO save(ClienteVO clienteVO) {
        Cliente newCliente = converteVOParaEntidade(clienteVO, null);
        clienteRepository.save(newCliente);
        return converteEntidadeParaVO(newCliente);
    }

//******************************************************************************************************************

    public ClienteVO update(ClienteVO clienteVO, Integer id) {
        Cliente cliente = converteVOParaEntidade(clienteVO, id);
        Cliente newCliente = clienteRepository.save(cliente);
        return converteEntidadeParaVO(newCliente);
    }

//********************************************************************************************************************

    public boolean delete(Integer id) {
        if (id != null) {
            clienteRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

//******************************************************************************************************************

    private ClienteVO converteEntidadeParaVO(Cliente cliente){
        ClienteVO clienteVO = new ClienteVO();
        List<PedidoVO> listPedidoVO = new ArrayList<>();

        clienteVO.setClienteId(cliente.getClienteId());
        clienteVO.setEmail(cliente.getEmail());
        clienteVO.setUsername(cliente.getUsername());
        clienteVO.setSenha(cliente.getSenha());
        clienteVO.setNome(cliente.getNome());
        clienteVO.setCpf(cliente.getCpf());
        clienteVO.setTelefone(cliente.getTelefone());
        clienteVO.setDataNascimento(cliente.getDataNascimento());

        for (Pedido lPedido : cliente.getPedidosByClienteId()) {
            PedidoVO pedidoVO = new PedidoVO();

            pedidoVO.setPedidoId(lPedido.getPedidoId());
            pedidoVO.setNumeroPedido(lPedido.getNumeroPedido());
            pedidoVO.setListaProdutosDoPedido(lPedido.getListaProdutosDoPedido());
            pedidoVO.setValorTotalPedido(lPedido.getValorTotalPedido());
            pedidoVO.setDataPedido(lPedido.getDataPedido());
            pedidoVO.setStatus(lPedido.getStatus());

            listPedidoVO.add(pedidoVO);
        }
        clienteVO.setPedidosByClienteId(listPedidoVO);

        return clienteVO;
    }

//******************************************************************************************************************

    private Cliente converteVOParaEntidade(ClienteVO clienteVO, Integer id) {
        Cliente cliente = new Cliente();
        List<Pedido> listPedido = new ArrayList<>();

        cliente.setClienteId((null == id) ? clienteVO.getClienteId() : id);
        cliente.setEmail(clienteVO.getEmail());
        cliente.setUsername(clienteVO.getUsername());
        cliente.setSenha(clienteVO.getSenha());
        cliente.setNome(clienteVO.getNome());
        cliente.setCpf(clienteVO.getCpf());
        cliente.setTelefone(clienteVO.getTelefone());
        cliente.setDataNascimento(clienteVO.getDataNascimento());

            for (PedidoVO lPedidoVO : clienteVO.getPedidosByClienteId()){
                Pedido pedido = new Pedido();

                pedido.setPedidoId(lPedidoVO.getPedidoId());
                pedido.setNumeroPedido(lPedidoVO.getNumeroPedido());
                pedido.setListaProdutosDoPedido(lPedidoVO.getListaProdutosDoPedido());
                pedido.setValorTotalPedido(lPedidoVO.getValorTotalPedido());
                pedido.setDataPedido(lPedidoVO.getDataPedido());
                pedido.setStatus(lPedidoVO.getStatus());

                listPedido.add(pedido);
        }
        cliente.setPedidosByClienteId(listPedido);

        return cliente;
    }



}
