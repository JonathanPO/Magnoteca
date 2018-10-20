/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projeto.interfacesImpl;

import br.com.projeto.conexao.CatchProperties;
import br.com.projeto.entidades.Multa;
import br.com.projeto.interfaces.MultaDao;
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
public class MultaDaoImpl implements MultaDao{
    
    private Connection connection;
    
    public MultaDaoImpl(Connection umaConnection) {
        this.connection = umaConnection;
    }
    
    /**
     * Método responsável por persistir os dados de uma Multa em um banco de dados especificado.
     * @param umaMulta
     * @return Uma variável int contendo o id gerado.
     */
    @Override
    public int persistir(Multa umaMulta){
        int id=0;
        try {
            CatchProperties catchProperties = new CatchProperties();
            Properties properties = catchProperties.getProperties("comandosSQL.properties");
            PreparedStatement preparedStatement = this.connection.prepareStatement(properties.getProperty("INSERT_MULTA"), Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, umaMulta.getDias_de_Multa());
            preparedStatement.setInt(2, umaMulta.getEmprestimo().getId());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while(resultSet.next()){
                id = resultSet.getInt(1);
            }

            return id;
        } catch (SQLException ex) {
            Logger.getLogger(MultaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    
}
