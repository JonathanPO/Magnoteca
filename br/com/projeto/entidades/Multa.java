package br.com.projeto.entidades;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ruty Medeiros
 */
public class Multa {
    private int id;
    private int dias_de_Multa;
    private Emprestimo emprestimo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDias_de_Multa() {
        return dias_de_Multa;
    }

    public void setDias_de_Multa(int dias_de_Multa) {
        this.dias_de_Multa = dias_de_Multa;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public Multa(int id, int dias_de_Multa, Emprestimo emprestimo) {
        this.id = id;
        this.dias_de_Multa = dias_de_Multa;
        this.emprestimo = emprestimo;
    }

    public Multa(int dias_de_Multa, Emprestimo emprestimo) {
        this.dias_de_Multa = dias_de_Multa;
        this.emprestimo = emprestimo;
    }
    
     @Override
    public String toString(){
        return this.dias_de_Multa + " " + this.emprestimo + " " + this.id;
    }
    
    
}
