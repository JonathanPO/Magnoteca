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
public class Livro {
    private int id;
    private String titulo;
    private String titulo_original;
    private String isbn; 
    private int volume;
    private int ano;
    private int edicao;
    private int quantidade;
    private Genero genero;
    private Autor autor;
    private Editora editora;

    public Livro(int id, String titulo, String titulo_original, String isbn, int volume, int ano, int edicao, int quantidade, Genero genero, Autor autor) {
        this.id = id;
        this.titulo = titulo;
        this.titulo_original = titulo_original;
        this.isbn = isbn;
        this.volume = volume;
        this.ano = ano;
        this.edicao = edicao;
        this.quantidade = quantidade;
        this.genero = genero;
        this.autor = autor;
    }

    public Livro(String titulo, String titulo_original, String isbn, int volume, int ano, int edicao, int quantidade, Genero genero, Autor autor) {
        this.titulo = titulo;
        this.titulo_original = titulo_original;
        this.isbn = isbn;
        this.volume = volume;
        this.ano = ano;
        this.edicao = edicao;
        this.quantidade = quantidade;
        this.genero = genero;
        this.autor = autor;
    }

    public Livro(String titulo, String titulo_original, String isbn, int volume, int ano, int edicao, int quantidade, Genero genero, Autor autor, Editora editora) {
        this.titulo = titulo;
        this.titulo_original = titulo_original;
        this.isbn = isbn;
        this.volume = volume;
        this.ano = ano;
        this.edicao = edicao;
        this.quantidade = quantidade;
        this.genero = genero;
        this.autor = autor;
        this.editora = editora;
    }

    public Livro(String titulo) {
        this.titulo = titulo;
    }

    public Livro(String titulo, int volume, int edicao, int quantidade, Autor autor) {
        this.titulo = titulo;
        this.volume = volume;
        this.edicao = edicao;
        this.quantidade = quantidade;
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo_original() {
        return titulo_original;
    }

    public void setTitulo_original(String titulo_original) {
        this.titulo_original = titulo_original;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }
   
}
