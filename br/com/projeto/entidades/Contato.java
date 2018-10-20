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
public class Contato {
    private int id;
    private String telefone;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Contato(int id, String telefone, String email) {
        this.id = id;
        this.telefone = telefone;
        this.email = email;
    }

    public Contato(String telefone, String email) {
        this.telefone = telefone;
        this.email = email;
    }

    public Contato(int id, String email) {
        this.id = id;
        this.email = email;
    }

    public Contato(int id) {
        this.id = id;
    }
    
}
