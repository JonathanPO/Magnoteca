/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.interfacesImpl;

import br.com.projeto.GUI.CadastrarNovoItemNoAcervo;
import br.com.projeto.GUI.PesquisaDeLivros;
import br.com.projeto.conexao.CatchProperties;
import br.com.projeto.entidades.Autor;
import br.com.projeto.interfaces.AcervoDao;
import br.com.projeto.entidades.Livro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ruty Medeiros
 */
public class AcervoDaoImpl implements AcervoDao {
    
    private Connection connection;
    
    public AcervoDaoImpl(Connection umaConnection) {
        this.connection = umaConnection;
    }

    /**
     * Método que persiste os dados de um Livro em um banco de dados especificado.
     * @param umLivro Objeto do tipo Livro.
     * @return Uma variável int contendo o id do Livro gerado.
     */
    @Override
    public int persistir(Livro umLivro) {
        try {
            int id = 0;
            CatchProperties catchProperties = new CatchProperties();
            Properties properties = catchProperties.getProperties("comandosSQL.properties");
            PreparedStatement preparedStatement = this.connection.prepareStatement(properties.getProperty("INSERT_LIVRO"), Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, umLivro.getTitulo());
            preparedStatement.setString(2, umLivro.getTitulo_original());
            preparedStatement.setString(3, umLivro.getIsbn());
            preparedStatement.setInt(4, umLivro.getVolume());
            preparedStatement.setInt(5, umLivro.getAno());
            preparedStatement.setInt(6, umLivro.getEdicao());
            preparedStatement.setInt(7, umLivro.getQuantidade());
            preparedStatement.setInt(8, umLivro.getGenero().getId());
            preparedStatement.setInt(9, umLivro.getEditora().getId());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
            return id;
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarNovoItemNoAcervo.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    List<Livro> livros = new ArrayList();
    
    /**
     * Método que busca, no banco de dados especificado, o id de um Livro.
     * @param umLivro
     * @return Uma variável int contendo o id buscado.
     */
    @Override
    public int buscarId(Livro umLivro){
        int id=0;
        try{
            CatchProperties catchProperties = new CatchProperties();
            Properties properties = catchProperties.getProperties("comandosSQL.properties");
            PreparedStatement preparedStatement = this.connection.prepareStatement(properties.getProperty("SELECT_ID_LIVRO"));
            preparedStatement.setString(1, umLivro.getTitulo());
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                id = resultSet.getInt(1);
            }
            return id;
            
        } catch(SQLException ex){
            Logger.getLogger(CadastrarNovoItemNoAcervo.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    
    @Override
    public List<Livro> buscarDadosLivros(){
        Livro livro=null;
        CatchProperties catchProperties = new CatchProperties();
        Properties properties = catchProperties.getProperties("comandosSQL.properties");
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(properties.getProperty("SELECT_TUDO_LIVRO"));
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String titulo = resultSet.getString("Titulo");
                int edicao = resultSet.getInt("Edicao");
                int volume = resultSet.getInt("Volume");
                int quantidade = resultSet.getInt("Quantidade");
                String autor = resultSet.getString("Nome");
                Autor autor1 = new Autor(autor);
                livro = new Livro(titulo, volume, edicao, quantidade, autor1);

                livros.add(livro);
            }
            return livros;
            
        } catch (SQLException ex) {
            Logger.getLogger(PesquisaDeLivros.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    @Override
    public List<Livro> buscarDadosLivrosPorTitulo(String titulo){
        Livro livro=null;
        CatchProperties catchProperties = new CatchProperties();
        Properties properties = catchProperties.getProperties("comandosSQL.properties");
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(properties.getProperty("SELECT_TUDO_LIVRO_TITULO"));
            preparedStatement.setString(1, titulo +"%");
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String tituloCorreto = resultSet.getString("Titulo");
                int edicao = resultSet.getInt("Edicao");
                int volume = resultSet.getInt("Volume");
                int quantidade = resultSet.getInt("Quantidade");
                String autor = resultSet.getString("Nome");
                Autor autor1 = new Autor(autor);
                livro = new Livro(tituloCorreto, volume, edicao, quantidade, autor1);

                livros.add(livro);
            }
            return livros;
            
        } catch (SQLException ex) {
            Logger.getLogger(PesquisaDeLivros.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    @Override
    public List<Livro> buscarDadosLivrosPorAutor(String autor){
        Livro livro=null;
        CatchProperties catchProperties = new CatchProperties();
        Properties properties = catchProperties.getProperties("comandosSQL.properties");
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(properties.getProperty("SELECT_TUDO_LIVRO_AUTOR"));
            preparedStatement.setString(1, autor +"%");
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String titulo = resultSet.getString("Titulo");
                int edicao = resultSet.getInt("Edicao");
                int volume = resultSet.getInt("Volume");
                int quantidade = resultSet.getInt("Quantidade");
                String autorCorreto = resultSet.getString("Nome");
                Autor autor1 = new Autor(autorCorreto);
                livro = new Livro(titulo, volume, edicao, quantidade, autor1);

                livros.add(livro);
            }
            return livros;
            
        } catch (SQLException ex) {
            Logger.getLogger(PesquisaDeLivros.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
