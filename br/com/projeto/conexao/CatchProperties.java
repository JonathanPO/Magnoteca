/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projeto.conexao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 20121164010392
 */
public class CatchProperties {
    
/**
 * Método que carrega um arquivo Properties especificado pelo nome do arquivo, que é recebido 
 * através do paramêtro.
 * @param propertieName Uma String contendo o nome do arquivo Properties a ser carregado.
 *
 * @return Um arquivo Properties com as propriedades do arquivo especificado já carregadas.
 */
    public Properties getProperties(String propertieName){
        Properties prop = new Properties();
        InputStream inpSt = ConexaoBanco.class.getClassLoader().getResourceAsStream(propertieName);

        try {
            prop.load(inpSt);
        } catch (IOException ex) {
            Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prop;
    }
}
