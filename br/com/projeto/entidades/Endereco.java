/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.entidades;

/**
 *
 * @author Jonathan Gabriel
 */
public class Endereco {
    
    private int id;
    private String logradouro;
    private String cidade;
    private String cep;
    private String bairro;
    private String estado;
    private String numero;
    private String complemento;

    public Endereco(String logradouro, String cidade, String cep, String bairro, String estado, String numero, String complemento) {
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.cep = cep;
        this.bairro = bairro;
        this.estado = estado;
        this.numero = numero;
        this.complemento = complemento;
    }

    public Endereco(int id) {
        this.id = id;
    }
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public String toString() {
        return this.id + " " + this.logradouro + " " + this.bairro;
    }
    
}
