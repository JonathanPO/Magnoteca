package br.com.projeto.interfacesImpl;

import br.com.projeto.GUI.CadastrarNovoCliente;
import br.com.projeto.conexao.CatchProperties;
import br.com.projeto.entidades.Cliente;
import br.com.projeto.entidades.Emprestimo;
import br.com.projeto.entidades.Livro;
import br.com.projeto.interfaces.EmprestimoDao;
import java.sql.Connection;
import java.sql.Date;
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
public class EmprestimoDaoImpl implements EmprestimoDao {
    
    private Connection connection;
    
    public EmprestimoDaoImpl(Connection umaConnection) {
        this.connection = umaConnection;
    }

    /**
     * Método responsável por persistir os dados de um Emprestimo em um banco de dados especificado.
     * @param umEmprestimo Um objeto do tipo Emprestimo.
     * @return Uma variável int contendo o id gerado.
     */
    @Override
    public int persistir(Emprestimo umEmprestimo) {

        int id=0;
        try {
            CatchProperties catchProperties = new CatchProperties();
            Properties properties = catchProperties.getProperties("comandosSQL.properties");
            PreparedStatement preparedStatement = this.connection.prepareStatement(properties.getProperty("INSERT_EMPRESTIMO"), Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setDate(1, umEmprestimo.getData_Emprestimo());
            preparedStatement.setDate(2, umEmprestimo.getPrevisao_Devolucao());
            preparedStatement.setInt(3, umEmprestimo.getLivro().getId());
            preparedStatement.setInt(4, umEmprestimo.getCliente().getId());
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
    
    List<Emprestimo> listarEmprestimos = new ArrayList();
    
    @Override
    public List<Emprestimo> buscarEmprestimos(Cliente umCliente){
        
        Emprestimo emprestimo=null;
        try{
            CatchProperties catchProperties = new CatchProperties();
            Properties properties = catchProperties.getProperties("comandosSQL.properties");
            PreparedStatement preparedStatement = this.connection.prepareStatement(properties.getProperty("SELECT_TUDO_EMPRESTIMO"));
            preparedStatement.setInt(1, umCliente.getId());
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String titulo = resultSet.getString(1);
                Date dataEmprestimo = resultSet.getDate(2);
                Date dataDevolucao = resultSet.getDate(3);
                
                if(dataDevolucao == null){
                    
                } else{
                    Livro livro = new Livro(titulo);
                    emprestimo = new Emprestimo(dataEmprestimo, dataDevolucao, livro);
                    listarEmprestimos.add(emprestimo);
                }
            }
            return listarEmprestimos;
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    @Override
    public List<Emprestimo> buscarEmprestimosAtuais(Cliente umCliente){
        
        Emprestimo emprestimo=null;
        try{
            CatchProperties catchProperties = new CatchProperties();
            Properties properties = catchProperties.getProperties("comandosSQL.properties");
            PreparedStatement preparedStatement = this.connection.prepareStatement(properties.getProperty("SELECT_TUDO_EMPRESTIMO"));
            preparedStatement.setInt(1, umCliente.getId());
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String titulo = resultSet.getString(1);
                Date dataEmprestimo = resultSet.getDate(2);
                Date previsaoDeDevolucao = resultSet.getDate(3);
                Date dataDevolucao = resultSet.getDate(4);
                
                if(dataDevolucao == null){
                    Livro livro = new Livro(titulo);
                    emprestimo = new Emprestimo(livro, dataEmprestimo, previsaoDeDevolucao);
                    listarEmprestimos.add(emprestimo);
                }
            }
            return listarEmprestimos;
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    @Override
    public Emprestimo buscarEmprestimo(int idLivro, int idCliente){
        
        Emprestimo emprestimo=null;
        try{
            CatchProperties catchProperties = new CatchProperties();
            Properties properties = catchProperties.getProperties("comandosSQL.properties");
            PreparedStatement preparedStatement = this.connection.prepareStatement(properties.getProperty("SELECT_ID_PREVISAODEDEVOLUCAO_EMPRESTIMO"));
            preparedStatement.setInt(1, idLivro);
            preparedStatement.setInt(2, idCliente);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                Date previsaoDevolucao = resultSet.getDate(2);
                
                emprestimo = new Emprestimo(id, previsaoDevolucao);
            }
            return emprestimo;
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    @Override
    public void updateEmprestimo(Emprestimo emprestimo){
        try {
            CatchProperties catchProperties = new CatchProperties();
            Properties properties = catchProperties.getProperties("comandosSQL.properties");
            PreparedStatement prepareStatement = this.connection.prepareStatement(properties.getProperty("UPDATE_EMPRESTIMO"));
            prepareStatement.setDate(1, emprestimo.getData_Devolucao());
            prepareStatement.setInt(2, emprestimo.getCliente().getId());
            prepareStatement.setInt(3, emprestimo.getLivro().getId());
            prepareStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
}
    