/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.interfaces;

import br.com.projeto.entidades.Cliente;

/**
 *
 * @author Jonathan Gabriel
 */
public interface ClienteDao {
    
    int persistir(Cliente umCliente);
    int buscarId(Cliente umCliente);
    String buscarSenha(Cliente umCliente);
    String allofCliente (Cliente umCliente);
    boolean alterarDados(Cliente umCliente);
    Cliente buscarTudoCliente(String umUsuario);
    
}
