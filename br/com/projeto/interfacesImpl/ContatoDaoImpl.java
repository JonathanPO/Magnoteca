/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projeto.interfacesImpl;

import br.com.projeto.GUI.CadastrarNovoCliente;
import br.com.projeto.conexao.CatchProperties;
import br.com.projeto.entidades.Contato;
import br.com.projeto.interfaces.ContatoDao;
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
public class ContatoDaoImpl implements ContatoDao {
    
    private Connection connection;
    
    public ContatoDaoImpl(Connection umaConnection) {
        this.connection = umaConnection;
    }
   
    /**
     * Método responsável por persistir os dados de um Contato em um banco de dados especificado.
     * @param umContato Objeto do tipo Contato.
     * @return Uma variável int contendo o id do Contato gerado.
     */
    @Override
    public int persitir(Contato umContato){
        int id=0;
        try {
            CatchProperties catchProperties = new CatchProperties();
            Properties properties = catchProperties.getProperties("comandosSQL.properties"); 
            PreparedStatement preparedStatement = this.connection.prepareStatement(properties.getProperty("INSERT_CONTATO"), Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, umContato.getTelefone());
            preparedStatement.setString(2, umContato.getEmail());            
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
    
    /**
     * Método responsável por alterar os dados de um Contato especificado.
     * @param umContato Um objeto do tipo Contato.
     * @return Uma variável boolean que retorna true caso a alteração seja realizada ou false caso alguma 
     * exceção seja lançada.
     */
    @Override
    public boolean alterarDados(Contato umContato){
        try {
            CatchProperties catchProperties = new CatchProperties();
            Properties properties = catchProperties.getProperties("comandosSQL.properties");
            PreparedStatement prepareStatement = this.connection.prepareStatement(properties.getProperty("UPDATE_CONTATO"));
            prepareStatement.setString(1, umContato.getEmail());
            prepareStatement.setInt(2, umContato.getId());
            prepareStatement.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    /**
     * Método que retorna um id de um Contato que tenha o email especificado.
     * @param umEmail Uma variável do tipo String.
     * @return Uma variável int contendo o id buscado.
     */
    @Override
    public int buscarId(String umEmail){
        int id=0;
        try {
            CatchProperties catchProperties = new CatchProperties();
            Properties properties = catchProperties.getProperties("comandosSQL.properties");
            PreparedStatement prepareStatement = this.connection.prepareStatement(properties.getProperty("SELECT_ID_CONTATO"));
            prepareStatement.setString(1,umEmail);
            
            ResultSet resultSet = prepareStatement.executeQuery();
            while(resultSet.next()){
                id = resultSet.getInt(1);
            }
            return id;
            
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    
    /**
     * Método responsável por retornar o email de um Contato que possui o id especificado.
     * @param id Uma variável do tipo int.
     * @return Uma variável String contendo o email buscado.
     */
    @Override
    public String buscarEmail(int id){
        String email=null;
        try {
            CatchProperties catchProperties = new CatchProperties();
            Properties properties = catchProperties.getProperties("comandosSQL.properties");
            PreparedStatement prepareStatement = this.connection.prepareStatement(properties.getProperty("SELECT_EMAIL_CONTATO"));
            prepareStatement.setInt(1, id);
            
            ResultSet resultSet = prepareStatement.executeQuery();
            while(resultSet.next()){
                email = resultSet.getString("Email");
            }
            return email;
            
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    @Override
    public void adicionarEditoraTelefone(int idEditora, int IdTelefone){
        try {
            CatchProperties catchProperties = new CatchProperties();
            Properties properties = catchProperties.getProperties("comandosSQL.properties");
            PreparedStatement preparedStatement = this.connection.prepareStatement(properties.getProperty("INSERT_EDITORATELEFONE"));
            preparedStatement.setInt(1, idEditora);
            preparedStatement.setInt(2, IdTelefone);
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}