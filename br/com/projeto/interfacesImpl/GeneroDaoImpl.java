/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.interfacesImpl;

import br.com.projeto.conexao.CatchProperties;
import br.com.projeto.entidades.Genero;
import br.com.projeto.interfaces.GeneroDao;
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
public class GeneroDaoImpl implements GeneroDao {

    private Connection connection;

    public GeneroDaoImpl(Connection umaConexao) {
        this.connection = umaConexao;
    }

    /**
     * Método responsável por persistir os dados de um Genero em um banco de
     * dados especificado.
     *
     * @param genero Um objeto do tipo Genero.
     * @return Uma variável int contendo o id gerado.
     */
    @Override
    public int persitir(Genero genero) {

        try {
            CatchProperties catchProperties = new CatchProperties();
            Properties properties = catchProperties.getProperties("comandosSQL.properties");
            int id = 0;
            PreparedStatement preparedStatement = this.connection.prepareStatement(properties.getProperty("INSERT_GENERO"), Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, genero.getNome());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
            return id;
        } catch (SQLException ex) {
            Logger.getLogger(GeneroDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    
    @Override
    public int buscarIdGenero(String genero){
        
        try {
            CatchProperties catchProperties = new CatchProperties();
            Properties properties = catchProperties.getProperties("comandosSQL.properties");
            int id = 0;
            PreparedStatement preparedStatement = this.connection.prepareStatement(properties.getProperty("SELECT_ID_GENERO"));
            preparedStatement.setString(1, genero);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
            return id;
        } catch (SQLException ex) {
            Logger.getLogger(GeneroDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

}
