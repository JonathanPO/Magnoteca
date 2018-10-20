package br.com.projeto.entidades;

import java.sql.Date;

public class Emprestimo {
    
    private int id;
    private Date data_Emprestimo;
    private Date previsao_Devolucao;
    private Date data_Devolucao;
    private Livro livro;
    private Cliente cliente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData_Emprestimo() {
        return data_Emprestimo;
    }

    public void setData_Emprestimo(Date data_Emprestimo) {
        this.data_Emprestimo = data_Emprestimo;
    }

    public Date getPrevisao_Devolucao() {
        return previsao_Devolucao;
    }

    public void setPrevisao_Devolucao(Date previsao_Devolucao) {
        this.previsao_Devolucao = previsao_Devolucao;
    }

    public Date getData_Devolucao() {
        return data_Devolucao;
    }

    public void setData_Devolucao(Date data_Devolucao) {
        this.data_Devolucao = data_Devolucao;
    }


    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Emprestimo(int id, Date data_Emprestimo, Date previsao_Devolucao, Date data_Devolucao, Livro livro, Cliente cliente) {
        this.id = id;
        this.data_Emprestimo = data_Emprestimo;
        this.previsao_Devolucao = previsao_Devolucao;
        this.data_Devolucao = data_Devolucao;
        this.livro = livro;
        this.cliente = cliente;
    }

    public Emprestimo(Date data_Emprestimo, Date previsao_Devolucao, Date data_Devolucao, Livro livro, Cliente cliente) {
        this.data_Emprestimo = data_Emprestimo;
        this.previsao_Devolucao = previsao_Devolucao;
        this.data_Devolucao = data_Devolucao;
        this.livro = livro;
        this.cliente = cliente;
    }

    public Emprestimo(Date data_Emprestimo, Date previsao_Devolucao, Livro livro, Cliente cliente) {
        this.data_Emprestimo = data_Emprestimo;
        this.previsao_Devolucao = previsao_Devolucao;
        this.livro = livro;
        this.cliente = cliente;
    }

    public Emprestimo(Date data_Emprestimo, Date data_Devolucao, Livro livro) {
        this.data_Emprestimo = data_Emprestimo;
        this.data_Devolucao = data_Devolucao;
        this.livro = livro;
    }

    public Emprestimo(Livro livro, Date data_Emprestimo, Date previsao_Devolucao) {
        this.data_Emprestimo = data_Emprestimo;
        this.previsao_Devolucao = previsao_Devolucao;
        this.livro = livro;
    }

    public Emprestimo(int id, Date previsao_Devolucao) {
        this.id = id;
        this.previsao_Devolucao = previsao_Devolucao;
    }
    
    @Override
    public String toString(){
        return this.cliente + " " + this.data_Devolucao + " " +  this.data_Emprestimo  + " " +  this.id  + " " + this.livro  + " " + this.previsao_Devolucao;
    }
}
