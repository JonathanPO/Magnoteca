/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projeto.interfaces;

import br.com.projeto.entidades.Contato;

/**
 *
 * @author Ruty Medeiros
 */
public interface ContatoDao {
    int persitir(Contato umContato);
    boolean alterarDados(Contato umContato);
    int buscarId(String umEmail);
    String buscarEmail(int id);
    void adicionarEditoraTelefone(int idEditora, int idContato);
    
}
