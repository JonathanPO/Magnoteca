/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.interfacesImpl;

import br.com.projeto.conexao.CatchProperties;
import br.com.projeto.entidades.Autor;
import br.com.projeto.interfaces.AutorDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 20121164010120
 */
public class AutorDaoImpl implements AutorDao {
    
    private Connection connection;
    
    public AutorDaoImpl(Connection umaConnection) {
        this.connection = umaConnection;
    }

    /**
     * Método responsável por persistir os dados de um Autor em um banco de dados especificado.
     * @param autor Objeto do tipo Autor.
     * @return Uma variável int contendo o id do Autor gerado.
     */
    @Override
    public int persistir(Autor autor) {        
        try {
            CatchProperties catchProperties = new CatchProperties();
            Properties properties = catchProperties.getProperties("comandosSQL.properties");
            int id = 0;
            PreparedStatement preparedStatement = this.connection.prepareStatement(properties.getProperty("INSERT_AUTOR"), Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, autor.getNome());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
            return id;
        } catch (SQLException ex) {
            Logger.getLogger(AutorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }

    }
    
    @Override
    public void adicionarAutorLivro(int idAutor, int idLivro){
        try {
            CatchProperties catchProperties = new CatchProperties();
            Properties properties = catchProperties.getProperties("comandosSQL.properties");
            PreparedStatement preparedStatement = this.connection.prepareStatement(properties.getProperty("INSERT_AUTORLIVRO"));
            preparedStatement.setInt(1, idAutor);
            preparedStatement.setInt(2, idLivro);
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(GeneroDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public int buscarId(String autor){
        
        try {
            CatchProperties catchProperties = new CatchProperties();
            Properties properties = catchProperties.getProperties("comandosSQL.properties");
            int id = 0;
            PreparedStatement preparedStatement = this.connection.prepareStatement(properties.getProperty("SELECT_ID_AUTOR"));
            preparedStatement.setString(1, autor);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
            return id;
        } catch (SQLException ex) {
            Logger.getLogger(AutorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
}
