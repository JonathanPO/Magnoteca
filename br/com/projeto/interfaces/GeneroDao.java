/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projeto.interfaces;

import br.com.projeto.entidades.Genero;

/**
 *
 * @author Ruty Medeiros
 */
public interface GeneroDao {
    int persitir(Genero genero);
    int buscarIdGenero(String genero);
    
}
