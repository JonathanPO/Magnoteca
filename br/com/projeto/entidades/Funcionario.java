/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.entidades;

import java.sql.Date;

/**
 *
 * @author Jonathan Gabriel
 */
public class Funcionario {
    private int id;
    private String nome;
    private String cpf;
    private String rg;
    private String sexo;
    private Date dataNasc;
    private String usuario;
    private String senha;
    private int bibliotecario;
    private Endereco endereco;
    private Contato contato;
        
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getBibliotecario() {
        return bibliotecario;
    }

    public void setBibliotecario(int bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public Funcionario(int id, String nome, String cpf, String rg, String sexo, Date dataNasc, String usuario, String senha, int bibliotecario, Endereco endereco, Contato contato) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.sexo = sexo;
        this.dataNasc = dataNasc;
        this.usuario = usuario;
        this.senha = senha;
        this.bibliotecario = bibliotecario;
        this.endereco = endereco;
        this.contato = contato;
    }

    public Funcionario(String nome, String cpf, String rg, String sexo, Date dataNasc, String usuario, String senha, int bibliotecario, Endereco endereco, Contato contato) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.sexo = sexo;
        this.dataNasc = dataNasc;
        this.usuario = usuario;
        this.senha = senha;
        this.bibliotecario = bibliotecario;
        this.endereco = endereco;
        this.contato = contato;
    }

    public Funcionario(int id, String nome, String cpf, String rg, String sexo, Date dataNasc, String senha, Endereco endereco, Contato contato) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.sexo = sexo;
        this.dataNasc = dataNasc;
        this.senha = senha;
        this.endereco = endereco;
        this.contato = contato;
    }
    
    public Funcionario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }
    
    public Funcionario(String usuario, String senha, int bibliotecario) {
        this.usuario = usuario;
        this.senha = senha;
        this.bibliotecario = bibliotecario;
    }

    public Funcionario(String senha, int bibliotecario) {
        this.senha = senha;
        this.bibliotecario = bibliotecario;
    }

    public Funcionario(String usuario) {
        this.usuario = usuario;
    }

    public Funcionario(int id) {
        this.id = id;
    }
    
}
