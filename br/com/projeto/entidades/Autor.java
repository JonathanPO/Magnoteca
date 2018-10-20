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
public class Autor {
    private int id;
    private String nome;
    private String site;
    private Livro livro;

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

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Autor(String nome, String site) {
        this.nome = nome;
        this.site = site;
    }

    public Autor(int id, String nome, String site) {
        this.id = id;
        this.nome = nome;
        this.site = site;
    }

    public Autor(String nome) {
        this.nome = nome;
    }
    
    
}
