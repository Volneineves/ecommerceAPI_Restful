package com.residencia.ecommerce.services;


import com.residencia.ecommerce.entities.Endereco;
import com.residencia.ecommerce.repositories.EnderecoRepository;
import com.residencia.ecommerce.vo.EnderecoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    public EnderecoRepository enderecoRepository;
//******************************************************************************************************************

    public Endereco findById(Integer id) {
        return enderecoRepository.findById(id).get();
    }
//******************************************************************************************************************

    public List<EnderecoVO> findAllVO(Integer pagina, Integer qtdRegistros) throws Exception {
        Pageable page = null;
        List<Endereco> listEndereco = null;
        List<Endereco> listEnderecoComPaginacao = null;
        List<EnderecoVO> listEnderecoVO = new ArrayList<>();

        try {
            if (null != pagina && null != qtdRegistros) {

                page = PageRequest.of(pagina, qtdRegistros);
                listEnderecoComPaginacao = enderecoRepository.findAll(page).getContent();

                for (Endereco lEndereco : listEnderecoComPaginacao) {
                    listEnderecoVO.add(converteEntidadeParaVO(lEndereco));
                }

            } else {
                listEndereco = enderecoRepository.findAll();

                for (Endereco lEndereco : listEndereco) {
                    listEnderecoVO.add(converteEntidadeParaVO(lEndereco));
                }
            }
        } catch (Exception e) {
            throw new Exception("Não foi possível recuperar a lista de endereços ::" + e.getMessage());
        }
        return listEnderecoVO;
    }

//******************************************************************************************************************


    public long count() {
        return enderecoRepository.count();
    }

//******************************************************************************************************************

    public Endereco save(Endereco endereco) {
        Endereco novoEndereco = enderecoRepository.save(endereco);
        if (novoEndereco.getEnderecoId() != null) {
            return novoEndereco;
        } else {
            return null;
        }

    }
//********************************************************************************************************************

//    public Endereco update(Endereco endereco) {
//
//        return enderecoRepository.save(endereco);
//    }


    //   OBS      analisar necessidade.

//     public Endereco update(Integer id,Endereco novoEndereco){
//        Endereco antigoEndereco = enderecoRepository.findById(id).get();
//        updateDados (antigoEndereco,novoEndereco);
//        return enderecoRepository.save(antigoEndereco);
//     }
//     private void updateDados(Endereco antigoEndereco , Endereco novoEndereco){
//        antigoEndereco.setCep(novoEndereco.getCep());
//        antigoEndereco.setClientesByEnderecoId(novoEndereco.getClientesByEnderecoId());
//        antigoEndereco.setUf(novoEndereco.getUf());
//        antigoEndereco.setCidade(novoEndereco.getCidade());
//        antigoEndereco.setBairro(novoEndereco.getBairro());
//        antigoEndereco.setRua(novoEndereco.getRua());
//        antigoEndereco.setNumero(novoEndereco.getNumero());
//        antigoEndereco.setComplemento(novoEndereco.getComplemento());
//  }


//********************************************************************************************************************

    public boolean delete(Integer id) {
        if (id != null) {
            enderecoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

//************************* Operações que o cliente ppoderá fazer após logado *****************************************

    public Endereco updateLogado(Integer id, Endereco endereco) {
        Endereco newEndereco = enderecoRepository.findById(id).get();
        updateDados(newEndereco, endereco);
        return enderecoRepository.save(newEndereco);
    }

    private void updateDados(Endereco newEndereco, Endereco endereco) {

        newEndereco.setBairro(endereco.getBairro());
        newEndereco.setCep(endereco.getCep());
        newEndereco.setRua(endereco.getRua());
        newEndereco.setCidade(endereco.getCidade());
        newEndereco.setNumero(endereco.getNumero());
        newEndereco.setComplemento(endereco.getComplemento());
        newEndereco.setUf(endereco.getUf());
    }

//*************************(fim) Operações que o cliente ppoderá fazer após logado (fim)*****************************************

    private EnderecoVO converteEntidadeParaVO(Endereco endereco) {
        EnderecoVO enderecoVO = new EnderecoVO();

        enderecoVO.setEnderecoId(endereco.getEnderecoId());
        enderecoVO.setCep(endereco.getCep());
        enderecoVO.setRua(endereco.getRua());
        enderecoVO.setBairro(endereco.getBairro());
        enderecoVO.setCidade(endereco.getCidade());
        enderecoVO.setNumero(endereco.getNumero());
        enderecoVO.setComplemento(endereco.getComplemento());
        enderecoVO.setUf(endereco.getUf());

        return enderecoVO;
    }
}
