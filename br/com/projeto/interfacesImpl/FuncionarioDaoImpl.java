/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.interfacesImpl;

import br.com.projeto.GUI.CadastrarNovoCliente;
import br.com.projeto.GUI.CadastrarNovoFuncionario;
import br.com.projeto.GUI.LoginFuncionario;
import br.com.projeto.conexao.CatchProperties;
import br.com.projeto.interfaces.FuncionarioDao;
import br.com.projeto.entidades.Contato;
import br.com.projeto.entidades.Endereco;
import br.com.projeto.entidades.Funcionario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jonathan Gabriel
 */
public class FuncionarioDaoImpl implements FuncionarioDao{
    
    private Connection connection;
    
    public FuncionarioDaoImpl(Connection umaConnection) {
        this.connection = umaConnection;
    }
    
    /**
     * Método responsável por persistir os dados de um Contato em um banco de dados especificado.
     * @param umFuncionario Um objeto do tipo Funcionario.
     * @return Uma variável int contendo o id gerado.
     */
    @Override
    public int persistir(Funcionario umFuncionario){
        
        int id=0;
        try {
            CatchProperties catchProperties = new CatchProperties();
            Properties properties = catchProperties.getProperties("comandosSQL.properties");
            PreparedStatement preparedStatement = this.connection.prepareStatement(properties.getProperty("INSERT_FUNCIONARIO"), Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, umFuncionario.getNome());
            preparedStatement.setString(2, umFuncionario.getCpf()); 
            preparedStatement.setString(3, umFuncionario.getRg());
            preparedStatement.setString(4, umFuncionario.getSexo());
            preparedStatement.setDate(5, umFuncionario.getDataNasc()); 
            preparedStatement.setInt(6, umFuncionario.getEndereco().getId()); 
            preparedStatement.setInt(7, umFuncionario.getContato().getId());
            preparedStatement.setString(8, umFuncionario.getSenha());
            preparedStatement.setString(9, umFuncionario.getUsuario()); 
            preparedStatement.setInt(10, umFuncionario.getBibliotecario());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while(resultSet.next()){
                id = resultSet.getInt(1);
            }

            return id;
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarNovoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    
    /**
     * Método responsável por buscar a senha de um Funcionario especificado.
     * @param umFuncionario Um objeto do tipo Funcionario.
     * @return Um objeto de Funcionario contendo a senha e o valor de bibliotecario.
     */
    @Override
    public Funcionario buscarSenha(Funcionario umFuncionario){
        Funcionario funcionario = null;
        String senha=null;
        int bibliotecario=0;
        try{
            PreparedStatement prepareStatement = this.connection.prepareStatement("SELECT Senha, Bibliotecario FROM funcionario WHERE NomeUsuario='"+ umFuncionario.getUsuario() +"';");

            ResultSet resultSet = prepareStatement.executeQuery("SELECT Senha, Bibliotecario FROM funcionario WHERE NomeUsuario='"+ umFuncionario.getUsuario() +"';");
            while(resultSet.next()){
                senha = resultSet.getString("Senha");
                bibliotecario = resultSet.getInt("Bibliotecario");
            }
            funcionario = new Funcionario(senha, bibliotecario);
            return funcionario;
            
        } catch(SQLException ex){
            Logger.getLogger(LoginFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } 
    }
    
    /**
     * Método responsável por buscar o id de um Funcionario especificado.
     * @param umfuncionario Um objeto do tipo Funcionario.
     * @return Uma variável int contendo o id bsucado.
     */
    @Override
    public int buscarId(Funcionario umfuncionario){
        int id=0;
        try{
            CatchProperties catchProperties = new CatchProperties();
            Properties properties = catchProperties.getProperties("comandosSQL.properties");
            PreparedStatement preparedStatement = this.connection.prepareStatement(properties.getProperty("SELECT_ID_FUNCIONARIO"));
            preparedStatement.setString(1, umfuncionario.getUsuario());
            preparedStatement.setString(2, umfuncionario.getSenha());
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                id = resultSet.getInt(1);
            }
            return id;
            
        } catch(SQLException ex){
            Logger.getLogger(CadastrarNovoCliente.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    
    /**
     * Método responsável por alterar os dados de um Funcionario especificado.
     * @param umFuncionario Um objeto do tipo Funcionario.
     * @return Uma variável boolean que retorna true caso os valores tenham sido alterados ou false caso alguma 
     * exceção seja lançada.
     */
    @Override
    public boolean alterarDados(Funcionario umFuncionario){
        try {
            CatchProperties catchProperties = new CatchProperties();
            Properties properties = catchProperties.getProperties("comandosSQL.properties");
            PreparedStatement prepareStatement = this.connection.prepareStatement(properties.getProperty("UPDATE_FUNCIONARIO"));
            prepareStatement.setString(1, umFuncionario.getSenha());
            prepareStatement.setString(2, umFuncionario.getUsuario());
            prepareStatement.setInt(3, umFuncionario.getId());
            prepareStatement.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    /**
     * Método responsável por buscar todos os dados de um Funcionario com o nome de usuário especificado.
     * @param umUsuario Uma variável do tipo String.
     * @return Um objeto de Funcionario contendo os dados buscados.
     */
    @Override
    public Funcionario buscarTudoFuncionario(String umUsuario){
        Funcionario funcionario = null;
        try {
            CatchProperties catchProperties = new CatchProperties();
            Properties properties = catchProperties.getProperties("comandosSQL.properties");
            PreparedStatement prepareStatement = this.connection.prepareStatement(properties.getProperty("SELECT_TUDO_FUNCIONARIO"));
            prepareStatement.setString(1, umUsuario);

            ResultSet resultSet = prepareStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("Id_Funcionario");
                String nome = resultSet.getString("Nome_funcionario");
                String cpf = resultSet.getString("Cpf");
                String rg = resultSet.getString("Rg");
                String sexo = resultSet.getString("Sexo");
                Date dataNasc = resultSet.getDate("Data_nasc");
                String senha = resultSet.getString("Senha");
                int idEndereco = resultSet.getInt("Id_Endereco");
                int idContato = resultSet.getInt("Id_Contato");
                Endereco endereco = new Endereco(idEndereco);
                Contato contato = new Contato(idContato);
                
                funcionario = new Funcionario(id, nome, cpf, rg, sexo, dataNasc, senha, endereco, contato);
            }
            return funcionario;
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
