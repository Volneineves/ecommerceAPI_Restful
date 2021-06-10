package com.residencia.ecommerce.entities;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Entity
public class Cliente {
    private Integer clienteId;
    private String email;
    private String username;
    private String senha;
    private String nome;
    private String cpf;
    private String telefone;
    private Calendar dataNascimento;
    private Endereco enderecoByEnderecoId;
    private List<Pedido> pedidosByClienteId;

    @Id
    @Column(name = "cliente_id")
    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    
    @Column(name = "senha")
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
    @Column(name = "nome")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
    @Column(name = "cpf")
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
    @Column(name = "telefone")
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    
    @Column(name = "data_nascimento")
    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


    @ManyToOne
    @JoinColumn(name = "endereco_id", referencedColumnName = "endereco_id")
    public Endereco getEnderecoByEnderecoId() {
        return enderecoByEnderecoId;
    }

    public void setEnderecoByEnderecoId(Endereco enderecoByEnderecoId) {
        this.enderecoByEnderecoId = enderecoByEnderecoId;
    }

    @OneToMany(mappedBy = "clienteByClienteId")
    public List<Pedido> getPedidosByClienteId() {
        return pedidosByClienteId;
    }

    public void setPedidosByClienteId(List<Pedido> pedidosByClienteId) {
        this.pedidosByClienteId = pedidosByClienteId;
    }
}
