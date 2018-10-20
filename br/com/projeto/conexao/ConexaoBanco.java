package br.com.projeto.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jonathan Gabriel
 */
public class ConexaoBanco {

    private static Connection connection;

    private ConexaoBanco() {

    }

    public static Connection getConnection() {
        if (ConexaoBanco.connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            Properties prop = null;
            CatchProperties catchProperties = new CatchProperties();
            prop = catchProperties.getProperties("banco.properties");
            
            try {
                connection = DriverManager.getConnection(prop.getProperty("con"), prop.getProperty("user"), prop.getProperty("password"));
                connection.setAutoCommit(false);
            } catch (SQLException ex) {
                Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return ConexaoBanco.connection;
    }

    /**
     * Método responsável por fazer uma conexão com o banco de dados
     * especificado.
     *
     * @return Um objeto Connection com uma conexão já estabelecida.
     */
    private Connection criarConexao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        Properties prop = null;
        CatchProperties catchProperties = new CatchProperties();
        prop = catchProperties.getProperties("banco.properties");

        Connection co = null;
        try {
            co = DriverManager.getConnection(prop.getProperty("con"), prop.getProperty("user"), prop.getProperty("password"));
            co.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
        return co;
    }

    /**
     * Método que recebe um objeto Connection e o usa para fazer um Statement.
     *
     * @param conn Objeto do tipo Connection.
     * @return Um objeto Statement.
     * @throws SQLException
     */
    public Statement getStatment(Connection conn) throws SQLException {
        Statement sutato = conn.createStatement();
        return sutato;
    }
}
