/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projeto.interfaces;

import br.com.projeto.entidades.Cliente;
import br.com.projeto.entidades.Emprestimo;
import java.util.List;

/**
 *
 * @author Ruty Medeiros
 */
public interface EmprestimoDao {
    int persistir(Emprestimo umEmprestimo);
    List<Emprestimo> buscarEmprestimos(Cliente umCliente);
    List<Emprestimo> buscarEmprestimosAtuais(Cliente umCliente);
    Emprestimo buscarEmprestimo(int idLivro, int idCliente);
    void updateEmprestimo(Emprestimo emprestimo);
    
}
