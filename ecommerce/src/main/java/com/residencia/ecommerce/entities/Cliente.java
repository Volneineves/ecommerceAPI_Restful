package com.residencia.ecommerce.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Cliente {
    private Integer clienteId;
    private String email;
    private String username;
    private String senha;
    private String nome;
    private String cpf;
    private String telefone;
    private Date dataNascimento;
    private Collection<Pedido> pedidosByClienteId;

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
    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @ManyToOne
    @JoinColumn(name = "endereco_id", referencedColumnName = "endereco_id")
    private Endereco enderecoByEnderecoId;

    public Endereco getEnderecoByEnderecoId() {
        return enderecoByEnderecoId;
    }

    public void setEnderecoByEnderecoId(Endereco enderecoByEnderecoId) {
        this.enderecoByEnderecoId = enderecoByEnderecoId;
    }

    @OneToMany(mappedBy = "clienteByClienteId")
    public Collection<Pedido> getPedidosByClienteId() {
        return pedidosByClienteId;
    }

    public void setPedidosByClienteId(Collection<Pedido> pedidosByClienteId) {
        this.pedidosByClienteId = pedidosByClienteId;
    }
}
