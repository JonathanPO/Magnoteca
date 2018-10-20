/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.interfaces;

import br.com.projeto.entidades.Funcionario;

/**
 *
 * @author Jonathan Gabriel
 */
public interface FuncionarioDao {
    
    int persistir(Funcionario umFuncionario);
    Funcionario buscarSenha(Funcionario umFuncionario);
    int buscarId(Funcionario umFuncionario);
    boolean alterarDados(Funcionario funcionario);
    Funcionario buscarTudoFuncionario(String umUsuario);
    
}
