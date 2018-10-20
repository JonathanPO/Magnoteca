/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.interfaces;

import br.com.projeto.entidades.Livro;
import java.util.List;

/**
 *
 * @author Jonathan Gabriel
 */
public interface AcervoDao {
    
    int persistir(Livro umLivro);
    int buscarId(Livro umlivro);
    List<Livro> buscarDadosLivros();
    List<Livro> buscarDadosLivrosPorTitulo(String titulo);
    List<Livro> buscarDadosLivrosPorAutor(String autor);
}
