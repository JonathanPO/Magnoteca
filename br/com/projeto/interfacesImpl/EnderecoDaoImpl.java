/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projeto.interfacesImpl;

import br.com.projeto.interfaces.EnderecoDao;
import br.com.projeto.entidades.Endereco;
import br.com.projeto.GUI.CadastrarNovoCliente;
import br.com.projeto.conexao.CatchProperties;
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
 * @author 20121164010392
 */
public class EnderecoDaoImpl implements EnderecoDao {
    
    private Connection connection;
    
    public EnderecoDaoImpl(Connection umaConnection) {
        this.connection = umaConnection;
    }

    /**
     * Método responsável por persistir os dados de um Endereco em um banco de dados especificado.
     * @param umEndereco Um objeto do tipo Endereco.
     * @return Uma variável int contendo o id gerado.
     */
    @Override
    public int persistir(Endereco umEndereco) {
        int id=0;
        try {
            CatchProperties catchProperties = new CatchProperties();
            Properties properties = catchProperties.getProperties("comandosSQL.properties"); 
            PreparedStatement preparedStatement = this.connection.prepareStatement(properties.getProperty("INSERT_ENDERECO"), Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, umEndereco.getLogradouro());
            preparedStatement.setString(2, umEndereco.getCidade());
            preparedStatement.setString(3, umEndereco.getCep());
            preparedStatement.setString(4, umEndereco.getEstado());
            preparedStatement.setString(5, umEndereco.getBairro());
            preparedStatement.setString(6, umEndereco.getNumero());
            preparedStatement.setString(7, umEndereco.getComplemento());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                id = resultSet.getInt(1);
            }
            return id;
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarNovoCliente.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    
}
