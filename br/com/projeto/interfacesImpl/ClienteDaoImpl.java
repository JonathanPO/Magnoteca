/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.interfacesImpl;

import br.com.projeto.GUI.CadastrarNovoCliente;
import br.com.projeto.GUI.LoginCliente;
import br.com.projeto.conexao.CatchProperties;
import br.com.projeto.interfaces.ClienteDao;
import br.com.projeto.entidades.Cliente;
import br.com.projeto.entidades.Contato;
import br.com.projeto.entidades.Endereco;
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
public class ClienteDaoImpl implements ClienteDao{
    
    private Connection connection;
    
    public ClienteDaoImpl(Connection umaConnection) {
        this.connection = umaConnection;
    }
    
    /**
     * Método responsável por persistir os dados de um Cliente em um banco de dados especificado.
     * @param umCliente Um Objeto do tipo Cliente.
     * @return Uma variável int contendo o id do Cliente gerado.
     */
    @Override
    public int persistir(Cliente umCliente){
        int id=0;
        try {
            CatchProperties catchProperties = new CatchProperties();
            Properties properties = catchProperties.getProperties("comandosSQL.properties"); 
            PreparedStatement preparedStatement = this.connection.prepareStatement(properties.getProperty("INSERT_CLIENTE"), Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, umCliente.getNome());
            preparedStatement.setString(2, umCliente.getCpf()); 
            preparedStatement.setString(3, umCliente.getRg());
            preparedStatement.setString(4, umCliente.getSexo());
            preparedStatement.setDate(5, umCliente.getDataNasc()); 
            preparedStatement.setInt(6, umCliente.getEndereco().getId()); 
            preparedStatement.setInt(7, umCliente.getContato().getId());
            preparedStatement.setString(8, umCliente.getSenha());
            preparedStatement.setString(9, umCliente.getUsuario());         
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while(resultSet.next()){
                id = resultSet.getInt(1);
            }
            return id;
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarNovoCliente.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    
    /**
     * Método responsável por buscar o id de um Cliente especificado.
     * @param umCliente Um Objeto do tipo Cliente.
     * @return Uma variável int contendo o id buscado.
     */
    @Override
    public int buscarId(Cliente umCliente){
        int id=0;
        try{
            CatchProperties catchProperties = new CatchProperties();
            Properties properties = catchProperties.getProperties("comandosSQL.properties");
            PreparedStatement preparedStatement = this.connection.prepareStatement(properties.getProperty("SELECT_ID_CLIENTE"));
            preparedStatement.setString(1,umCliente.getUsuario());
            preparedStatement.setString(2,umCliente.getSenha());
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
     * Método responsável por buscar a senha de um Cliente especificado.
     * @param umCliente Um objeto do tipo Cliente.
     * @return Uma variável String contendo a senha buscada.
     */
    @Override
    public String buscarSenha(Cliente umCliente){
        String senha=null;
        try {
            PreparedStatement prepareStatement = this.connection.prepareStatement("SELECT Senha FROM cliente WHERE NomeUsuario='"+ umCliente.getUsuario() +"';");

            ResultSet resultSet = prepareStatement.executeQuery("SELECT Senha FROM cliente WHERE NomeUsuario='"+ umCliente.getUsuario() +"';");
            while(resultSet.next()){
                senha = resultSet.getString("Senha");
            }
            return senha;
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginCliente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    /**
     * 
     * @param umCliente
     * @return 
     */
    @Override
    public String allofCliente(Cliente umCliente){      
        try {
            PreparedStatement prepareStatement = this.connection.prepareStatement("SELECT * FROM cliente WHERE NomeUsuario= 1;");            
            prepareStatement.setString(1, umCliente.getUsuario());
            ResultSet resultSet = prepareStatement.executeQuery();
            while(resultSet.next()){
                int id_cliente = resultSet.getInt("Id_cliente");
                String nome_cliente = resultSet.getString("Nome_cliete");
                String cpf = resultSet.getString("Cpf");
                String rg = resultSet.getString("Rg");
                String Sexo = resultSet.getString("Sexo");
                Date data = resultSet.getDate("Data_nasc");
                int id_Endereco = resultSet.getInt("Id_Endereco");
                int id_contato = resultSet.getInt("id_Endereco");
                String usuario = resultSet.getString("NomeUsuario");
                String senha = resultSet.getString("Senha");                                                 
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginCliente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return null;
    }
    
    /**
     * Método responsável por alterar os dados de um Cliente especificado.
     * @param umCliente Um objeto do tipo Cliente.
     * @return Uma variável boolean que retorn true caso a alteração tenha sido feita ou false caso alguma 
     * exceção seja lançada.
     */
    @Override
    public boolean alterarDados(Cliente umCliente){
        try {
            CatchProperties catchProperties = new CatchProperties();
            Properties properties = catchProperties.getProperties("comandosSQL.properties");
            PreparedStatement prepareStatement = this.connection.prepareStatement(properties.getProperty("UPDATE_CLIENTE"));
            prepareStatement.setString(1, umCliente.getSenha());
            prepareStatement.setString(2, umCliente.getUsuario());
            prepareStatement.setInt(3, umCliente.getId());
            prepareStatement.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginCliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    /**
     * Método responsável por buscar todos os dados de um Cliente a partir de seu usuario.
     * @param umUsuario Um objeto do tipo String.
     * @return Um objeto do tipo Cliente contendo os dados buscados.
     */
    
    @Override
    public Cliente buscarTudoCliente(String umUsuario){
        Cliente cliente = null;
        try {
            CatchProperties catchProperties = new CatchProperties();
            Properties properties = catchProperties.getProperties("comandosSQL.properties");
            PreparedStatement prepareStatement = this.connection.prepareStatement(properties.getProperty("SELECT_TUDO_CLIENTE"));
            prepareStatement.setString(1, umUsuario);

            ResultSet resultSet = prepareStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("Id_cliente");
                String nome = resultSet.getString("Nome_cliente");
                String cpf = resultSet.getString("Cpf");
                String rg = resultSet.getString("Rg");
                String sexo = resultSet.getString("Sexo");
                Date dataNasc = resultSet.getDate("Data_nasc");
                int idEndereco = resultSet.getInt("Id_Endereco");
                int idContato = resultSet.getInt("Id_Contato");
                String senha = resultSet.getString("Senha");
                Endereco endereco = new Endereco(idEndereco);
                Contato contato = new Contato(idContato);
                
                cliente = new Cliente(id, nome, cpf, rg, sexo, dataNasc, senha, endereco, contato);
            }
            return cliente;
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginCliente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
