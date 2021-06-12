package com.residencia.ecommerce.controllers;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.residencia.ecommerce.vo.EnderecoVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ViaCepController implements Serializable {

    private static final long serialVersionUID = 6046704732666502085L;

    @GetMapping(value="/getCep/{cep}")
    public ResponseEntity<EnderecoVO> doObterCep(@PathVariable(name = "cep") String cep) {

        RestTemplate restTemplate = new RestTemplate();

        String uri = "http://viacep.com.br/ws/{cep}/json/";

        Map<String, String> params = new HashMap<String, String>();
        params.put("cep", cep);

        EnderecoVO enderecoVO = restTemplate.getForObject(uri, EnderecoVO.class, params);

        return new ResponseEntity<EnderecoVO>(enderecoVO, HttpStatus.OK);
    }
}