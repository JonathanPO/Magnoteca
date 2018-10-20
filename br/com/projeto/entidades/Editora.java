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
public class Editora {
    private int id;
    private String nome;
    private String tradutor;

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

    public String getTradutor() {
        return tradutor;
    }

    public void setTradutor(String tradutor) {
        this.tradutor = tradutor;
    }

    public Editora(int id, String nome, String tradutor) {
        this.id = id;
        this.nome = nome;
        this.tradutor = tradutor;
    }

    public Editora(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Editora(String nome) {
        this.nome = nome;
    }
    
}
