/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projeto.interfaces;

import br.com.projeto.entidades.Endereco;

/**
 *
 * @author 20121164010392
 */
public interface EnderecoDao {
    
    int persistir(Endereco umEndereco);
    
}
