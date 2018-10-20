/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projeto.interfaces;

import br.com.projeto.entidades.Autor;

/**
 *
 * @author 20121164010120
 */
public interface AutorDao {
    
    int persistir(Autor autor);
    void adicionarAutorLivro(int idAutor, int idLivro);
    int buscarId(String autor);
    
}
