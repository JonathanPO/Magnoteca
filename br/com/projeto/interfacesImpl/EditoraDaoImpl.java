/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projeto.interfacesImpl;

import br.com.projeto.conexao.CatchProperties;
import br.com.projeto.entidades.Editora;
import br.com.projeto.interfaces.EditoraDao;
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
 * @author Ruty Medeiros
 */
public class EditoraDaoImpl implements EditoraDao {
    
    private Connection connection;
    
    public EditoraDaoImpl(Connection umaConnection) {
        this.connection = umaConnection;
    }
    
    /**
     * Método responsável por persistir os dados de uma Editora em um banco de dados especificado.
     * @param editora
     * @return Uma variável int contendo o id gerado.
     */
    @Override
    public int persitir(Editora editora){
         try {
            CatchProperties catchProperties = new CatchProperties();
            Properties properties = catchProperties.getProperties("comandosSQL.properties");
            int id = 0;
            PreparedStatement preparedStatement = this.connection.prepareStatement(properties.getProperty("INSERT_EDITORA"), Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, editora.getNome());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
            return id;
        } catch (SQLException ex) {
            Logger.getLogger(EditoraDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    
    @Override
    public int buscarId(String editora){
        
        try {
            CatchProperties catchProperties = new CatchProperties();
            Properties properties = catchProperties.getProperties("comandosSQL.properties");
            int id = 0;
            PreparedStatement preparedStatement = this.connection.prepareStatement(properties.getProperty("SELECT_ID_EDITORA"));
            preparedStatement.setString(1, editora);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
            return id;
        } catch (SQLException ex) {
            Logger.getLogger(EditoraDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    
}
