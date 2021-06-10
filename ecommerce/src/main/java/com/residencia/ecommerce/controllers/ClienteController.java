package com.residencia.ecommerce.controllers;

import com.residencia.ecommerce.entities.Cliente;
import com.residencia.ecommerce.services.ClienteService;
import com.residencia.ecommerce.vo.ClienteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    public ClienteService clienteService;

    @GetMapping("/{id}")
    public ResponseEntity<ClienteVO> findById(@PathVariable Integer id) {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(clienteService.findById(id),
                headers, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ClienteVO>> findAllVO(
            @RequestParam(required = false) Integer pagina,
            @RequestParam(required = false) Integer qtdRegistros)
            throws Exception {

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(clienteService.findAllVO(pagina,
                qtdRegistros), headers, HttpStatus.OK);
    }

    @GetMapping("/count")
    public Long count() {
        return clienteService.count();
    }

    @PostMapping
    public ResponseEntity<ClienteVO> save(@RequestBody ClienteVO clienteVO){
        HttpHeaders headers = new HttpHeaders();

        ClienteVO newClienteVO = clienteService.save(clienteVO);

        if(null != newClienteVO)
            return new ResponseEntity<>(newClienteVO, headers, HttpStatus.OK);
        else
            return new ResponseEntity<>(newClienteVO, headers, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ClienteVO update(@PathVariable Integer id, @RequestBody ClienteVO clienteVO){
        return clienteService.update(clienteVO, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> delete(@RequestParam Integer id) {
        HttpHeaders headers = new HttpHeaders();
        boolean isRemoved = clienteService.delete(id);
        if (isRemoved) {
            return new ResponseEntity<>(headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        }
    }
}