package com.residencia.ecommerce.controllers;

import com.residencia.ecommerce.entities.Endereco;
import com.residencia.ecommerce.services.EnderecoService;
import com.residencia.ecommerce.vo.EnderecoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Endereco")
public class EnderecoController {

    @Autowired
    public EnderecoService enderecoService;

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> findById(@PathVariable Integer id) {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(enderecoService.findById(id), headers, HttpStatus.OK);
    }

    @GetMapping("/todos-enderecos")
    public ResponseEntity<List<EnderecoVO>> findAllVO(
            @RequestParam(required = false) Integer pagina,
            @RequestParam(required = false) Integer qtdRegistros)
            throws Exception {

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(enderecoService.findAllVO(pagina,
                qtdRegistros), headers, HttpStatus.OK);
    }

    @GetMapping("/count")
    public Long count() {
        return enderecoService.count();
    }

    @PostMapping
    public ResponseEntity<Endereco> save(@RequestBody Endereco endereco) {
        HttpHeaders headers = new HttpHeaders();

        Endereco novoEndereco = enderecoService.save(endereco);

        if (null != novoEndereco)
            return new ResponseEntity<>(novoEndereco, headers, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, headers, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> update(@PathVariable Integer id, @RequestBody Endereco endereco) {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(enderecoService.updateLogado(id, endereco), headers, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Endereco> delete(@PathVariable Integer id) {
        try {
            enderecoService.delete(id);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}