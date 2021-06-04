package com.residencia.ecommerce.services;

import com.residencia.ecommerce.entities.Categoria;
import com.residencia.ecommerce.entities.Cliente;

import com.residencia.ecommerce.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    public ClienteRepository clienteRepository;
//******************************************************************************************************************

    public Cliente findById (Integer id){
        Cliente cliente = clienteRepository.findById(id).get();
        return cliente;
    }
//******************************************************************************************************************

    public List<Cliente> findAll(Integer id){
        return clienteRepository.findAll();
    }

//******************************************************************************************************************


    public long count() {
        return clienteRepository.count();
    }

//******************************************************************************************************************

    public Cliente save (Cliente cliente){
        Cliente novoCliente = clienteRepository.save(cliente);
        if(novoCliente.getClienteId()!=null){
            return novoCliente;
        }
        else{ return null; }

    }
//********************************************************************************************************************

    public Cliente update(Cliente cliente ){

        return clienteRepository.save(cliente);
    }

    /*
                    OBS      analisar necessidade.

     public Cliente update(Integer id,Cliente novoCliente){
        Cliente antigoCliente = clienteRepository.findById(id).get();
        updateDados (antigoCliente,novoCliente);
        return clienteRepository.save(antigoCliente);
     }
     private void updateDados(Cliente antigoCliente , Cliente novoCliente){
        antigoCliente.setNome(novoCliente.getNome());
        antigoCliente.setEmail(novoCliente.getEmail());
        antigoCliente.setCpf(novoCliente.getCpf());
        antigoCliente.setUserName(novoCliente.getUserName());
        antigoCliente.setSenha(novoCliente.getSenha());
        antigoCliente.setTelefone(novoCliente.getTelefone());
        antigoCliente.setDataDeNascimento(novoCliente.getDataDeNascimento());



     }

     */





//********************************************************************************************************************

    public boolean delete(Integer id) {
        if (id != null) {
            clienteRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }


}
