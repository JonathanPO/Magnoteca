package br.com.projeto.GUI;

import br.com.projeto.conexao.ConexaoBanco;
import br.com.projeto.interfaces.EnderecoDao;
import br.com.projeto.entidades.Cliente;
import br.com.projeto.entidades.Contato;
import br.com.projeto.entidades.Endereco;
import br.com.projeto.interfaces.ClienteDao;
import br.com.projeto.interfaces.ContatoDao;
import br.com.projeto.interfacesImpl.ClienteDaoImpl;
import br.com.projeto.interfacesImpl.ContatoDaoImpl;
import br.com.projeto.interfacesImpl.EnderecoDaoImpl;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rafael Cardozo
 */
public class CadastrarNovoCliente extends javax.swing.JFrame {

    /**
     * Creates new form CadastrarNovoCliente
     */
    public CadastrarNovoCliente() {
        initComponents();

        try {
            Image icon = Toolkit.getDefaultToolkit().getImage("src\\Imagens\\images.png");
            setIconImage(icon);

        } catch (Exception e) {
            e.printStackTrace();
        }
        setSize(951, 580);
        this.getContentPane().setBackground(Color.WHITE);
        //myJFrame.getContentPane().setBackground( );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        confirmar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        avisos = new javax.swing.JTextPane();
        cancelar = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cpf = new javax.swing.JTextField();
        estado = new javax.swing.JTextField();
        nomeUsuario = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        dia = new javax.swing.JComboBox();
        mes = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        senha = new javax.swing.JPasswordField();
        confirmarSenha = new javax.swing.JPasswordField();
        sexo = new javax.swing.JComboBox();
        rg = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        cep = new javax.swing.JTextField();
        logradouro = new javax.swing.JTextField();
        nome = new javax.swing.JTextField();
        cidade = new javax.swing.JTextField();
        complemento = new javax.swing.JTextField();
        bairro = new javax.swing.JTextField();
        telefone = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        numero = new javax.swing.JTextField();
        ano = new javax.swing.JComboBox();

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/fundo.jpg"))); // NOI18N

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/fundo.jpg"))); // NOI18N
        jLabel14.setText("jLabel13");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Magnoteca");
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Linux Libertine G", 0, 24)); // NOI18N
        jLabel1.setText("CADASTRAR NOVO CLIENTE");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(280, 30, 340, 30);

        confirmar.setFont(new java.awt.Font("Centaur", 0, 11)); // NOI18N
        confirmar.setText("Confirmar");
        confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarActionPerformed(evt);
            }
        });
        getContentPane().add(confirmar);
        confirmar.setBounds(710, 480, 76, 34);

        avisos.setForeground(new java.awt.Color(255, 0, 0));
        avisos.setCaretColor(new java.awt.Color(255, 0, 0));
        avisos.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        avisos.setFocusCycleRoot(false);
        avisos.setFocusable(false);
        jScrollPane3.setViewportView(avisos);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(750, 310, 180, 130);

        cancelar.setFont(new java.awt.Font("Centaur", 0, 11)); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(cancelar);
        cancelar.setBounds(800, 480, 76, 34);

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/MarcadorBG.jpg"))); // NOI18N
        getContentPane().add(jLabel19);
        jLabel19.setBounds(800, -10, 85, 290);

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Logo.jpg"))); // NOI18N
        getContentPane().add(jLabel24);
        jLabel24.setBounds(10, 470, 320, 70);

        jLabel4.setFont(new java.awt.Font("Linux Libertine G", 0, 18)); // NOI18N
        jLabel4.setText("Nome Completo:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(80, 90, 150, 22);

        jLabel2.setFont(new java.awt.Font("Linux Libertine G", 0, 18)); // NOI18N
        jLabel2.setText("CPF:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(170, 130, 80, 22);

        jLabel3.setFont(new java.awt.Font("Linux Libertine G", 0, 18)); // NOI18N
        jLabel3.setText("Nome de Usuário: ");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3);
        jLabel3.setBounds(70, 210, 160, 22);

        jLabel5.setFont(new java.awt.Font("Linux Libertine G", 0, 18)); // NOI18N
        jLabel5.setText("Senha:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(480, 210, 80, 22);

        jLabel6.setFont(new java.awt.Font("Linux Libertine G", 0, 18)); // NOI18N
        jLabel6.setText("E-mail:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(390, 250, 80, 22);

        jLabel7.setFont(new java.awt.Font("Linux Libertine G", 0, 18)); // NOI18N
        jLabel7.setText("Data de nascimento:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(310, 170, 170, 22);

        cpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfActionPerformed(evt);
            }
        });
        try {
            javax.swing.text.MaskFormatter cpfx = new javax.swing.text.MaskFormatter("###.###.###-##");
            cpf = new javax.swing.JFormattedTextField(cpfx);
        }catch(Exception e){
            System.exit(1);
        }
        getContentPane().add(cpf);
        cpf.setBounds(230, 130, 170, 30);

        estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadoActionPerformed(evt);
            }
        });
        getContentPane().add(estado);
        estado.setBounds(530, 370, 170, 30);

        nomeUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(nomeUsuario);
        nomeUsuario.setBounds(230, 210, 230, 30);
        getContentPane().add(email);
        email.setBounds(460, 250, 240, 30);

        dia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        getContentPane().add(dia);
        dia.setBounds(480, 170, 60, 30);

        mes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
        mes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesActionPerformed(evt);
            }
        });
        getContentPane().add(mes);
        mes.setBounds(540, 170, 60, 30);

        jLabel13.setFont(new java.awt.Font("Linux Libertine G", 0, 18)); // NOI18N
        jLabel13.setText("Repita a Senha:");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(90, 250, 140, 22);
        getContentPane().add(senha);
        senha.setBounds(550, 210, 150, 30);
        getContentPane().add(confirmarSenha);
        confirmarSenha.setBounds(230, 250, 150, 30);

        sexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "M", "F" }));
        getContentPane().add(sexo);
        sexo.setBounds(230, 170, 70, 30);
        getContentPane().add(rg);
        rg.setBounds(570, 130, 130, 30);

        jLabel10.setFont(new java.awt.Font("Linux Libertine G", 0, 18)); // NOI18N
        jLabel10.setText("Identidade (RG):");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(420, 130, 150, 22);

        jLabel11.setFont(new java.awt.Font("Linux Libertine G", 0, 18)); // NOI18N
        jLabel11.setText("Sexo:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(170, 170, 70, 22);

        jLabel12.setFont(new java.awt.Font("Linux Libertine G", 0, 18)); // NOI18N
        jLabel12.setText("Logradouro:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(120, 330, 140, 22);

        jLabel15.setFont(new java.awt.Font("Linux Libertine G", 0, 18)); // NOI18N
        jLabel15.setText("Cidade:");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(150, 370, 160, 22);

        jLabel16.setFont(new java.awt.Font("Linux Libertine G", 0, 18)); // NOI18N
        jLabel16.setText("Bairro:");
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel16);
        jLabel16.setBounds(160, 410, 150, 22);

        jLabel17.setFont(new java.awt.Font("Linux Libertine G", 0, 18)); // NOI18N
        jLabel17.setText("Número:");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(550, 330, 110, 22);

        jLabel20.setFont(new java.awt.Font("Linux Libertine G", 0, 18)); // NOI18N
        jLabel20.setText("Complemento:");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(400, 410, 130, 22);

        jLabel21.setFont(new java.awt.Font("Linux Libertine G", 0, 18)); // NOI18N
        jLabel21.setText("CEP:");
        getContentPane().add(jLabel21);
        jLabel21.setBounds(440, 290, 150, 22);

        jLabel22.setFont(new java.awt.Font("Linux Libertine G", 0, 18)); // NOI18N
        jLabel22.setText("Estado:");
        getContentPane().add(jLabel22);
        jLabel22.setBounds(460, 370, 120, 22);

        cep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cepActionPerformed(evt);
            }
        });
        try {
            javax.swing.text.MaskFormatter cepx = new javax.swing.text.MaskFormatter("#####-###");
            cep = new javax.swing.JFormattedTextField(cepx);
        }catch(Exception e){
            System.exit(1);
        }
        getContentPane().add(cep);
        cep.setBounds(490, 290, 210, 30);

        logradouro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logradouroActionPerformed(evt);
            }
        });
        getContentPane().add(logradouro);
        logradouro.setBounds(230, 330, 310, 30);

        nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeActionPerformed(evt);
            }
        });
        getContentPane().add(nome);
        nome.setBounds(230, 90, 470, 30);

        cidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cidadeActionPerformed(evt);
            }
        });
        getContentPane().add(cidade);
        cidade.setBounds(230, 370, 220, 30);

        complemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                complementoActionPerformed(evt);
            }
        });
        complemento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                complementoKeyPressed(evt);
            }
        });
        getContentPane().add(complemento);
        complemento.setBounds(520, 410, 180, 30);

        bairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bairroActionPerformed(evt);
            }
        });
        bairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bairroKeyPressed(evt);
            }
        });
        getContentPane().add(bairro);
        bairro.setBounds(230, 410, 160, 30);

        telefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefoneActionPerformed(evt);
            }
        });
        getContentPane().add(telefone);
        telefone.setBounds(230, 290, 200, 30);

        jLabel23.setFont(new java.awt.Font("Linux Libertine G", 0, 18)); // NOI18N
        jLabel23.setText("Telefone:");
        getContentPane().add(jLabel23);
        jLabel23.setBounds(140, 290, 130, 22);

        numero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numeroActionPerformed(evt);
            }
        });
        getContentPane().add(numero);
        numero.setBounds(630, 330, 70, 30);

        ano.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2015","2014","2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921", "1920", "1919", "1918", "1917", "1916", "1915", "1914", "1913" }));
        getContentPane().add(ano);
        ano.setBounds(600, 170, 100, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarActionPerformed
        String nomeV = nome.getText();
        String cpfV = cpf.getText();
        String rgV = rg.getText();
        String sexoV = (String) sexo.getSelectedItem();
        String usuarioV = nomeUsuario.getText();
        char[] senhaVChar = senha.getPassword();
        String senhaV = new String(senhaVChar);
        char[] verificacaoSenhaChar = confirmarSenha.getPassword();
        String verificacaoSenha = new String(verificacaoSenhaChar);

        String diaV = (String) dia.getSelectedItem();
        int mesV = mes.getSelectedIndex();
        String anoV = (String) ano.getSelectedItem();
        int day = Integer.parseInt(diaV);
        int year = Integer.parseInt(anoV);
        
        Date data = new Date(year - 1900, mesV, day);

        String emailV = email.getText();
        String telefoneV = telefone.getText();

        String logradouroV = logradouro.getText();
        String cidadeV = cidade.getText();
        String cepV = cep.getText();
        String bairroV = bairro.getText();
        String estadoV = estado.getText();
        String numeroV = numero.getText();
        String complementoV = complemento.getText();
        
        boolean dadosErrados = false;
        avisos.setText(null);

        if (nomeV.equals("") || cpfV.equals("") || rgV.equals("") || usuarioV.equals("") || senhaV.equals("")
                || verificacaoSenha.equals("") || emailV.equals("") || telefoneV.equals("") || logradouroV.equals("")
                || cidadeV.equals("") || cepV.equals("") || bairroV.equals("") || estadoV.equals("")
                || numeroV.equals("")) {
            avisos.setText(avisos.getText() + "- Nenhum dos campos, exceto complemento, podem ficar em branco\n");
            dadosErrados = true;
        } 

        Cliente cliente = new Cliente(usuarioV);
        ClienteDaoImpl clienteDaoImpl = new ClienteDaoImpl(ConexaoBanco.getConnection());
        String usuarioBanco = clienteDaoImpl.buscarSenha(cliente);
        try {
            ConexaoBanco.getConnection().commit();
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarNovoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (usuarioBanco != null){
            avisos.setText(avisos.getText()+"- O nome de usuario já está sendo utilizado\n");
            dadosErrados = true;
        } 
        
        if ((usuarioV.length() < 5) || (usuarioV.length() > 12)) {            
            avisos.setText(avisos.getText() + "- Utilize no mínimo 5 e no máximo 12 caracteres para o nome de usuario\n");
            dadosErrados = true;
        }

        if ((senhaV.length() < 5) || (senhaV.length() > 8)) {
            avisos.setText(avisos.getText() + "- Utilize no mínimo 5 e no máximo 8 caracteres para a senha\n");
            dadosErrados = true;
        }

        if (!verificacaoSenha.equals(senhaV)) {
            avisos.setText(avisos.getText() + "- As senhas não conferem\n");
            dadosErrados = true;
        }              

        if(dadosErrados == false){
            Endereco endereco = new Endereco(logradouroV, cidadeV, cepV, bairroV, estadoV, numeroV, complementoV);
            EnderecoDao enderecoDao = new EnderecoDaoImpl(ConexaoBanco.getConnection());
            int idEndereco = enderecoDao.persistir(endereco);
            endereco.setId(idEndereco);

            Contato contato = new Contato(telefoneV, emailV);
            ContatoDao contatoDao = new ContatoDaoImpl(ConexaoBanco.getConnection());
            int idContato = contatoDao.persitir(contato);
            contato.setId(idContato);

            Cliente cliente2 = new Cliente(nomeV, cpfV, rgV, sexoV, data, usuarioV, senhaV, endereco, contato);
            ClienteDao clienteDao = new ClienteDaoImpl(ConexaoBanco.getConnection());
            int idCliente = clienteDao.persistir(cliente2);                

            try {
                JOptionPane.showMessageDialog(this, "Cliente Cadastrado com Sucesso");
                ConexaoBanco.getConnection().commit();
            } catch (HeadlessException | SQLException e) {
                e.printStackTrace();
                try {
                    ConexaoBanco.getConnection().rollback();
                } catch (SQLException ex) {
                    Logger.getLogger(CadastrarNovoCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            dispose();
        }
    }//GEN-LAST:event_confirmarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        
        dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void cpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpfActionPerformed

    private void estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estadoActionPerformed

    private void nomeUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeUsuarioActionPerformed

    }//GEN-LAST:event_nomeUsuarioActionPerformed

    private void mesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mesActionPerformed

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseClicked

    private void cepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cepActionPerformed

    private void logradouroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logradouroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logradouroActionPerformed

    private void nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeActionPerformed

    private void cidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cidadeActionPerformed

    private void complementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_complementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_complementoActionPerformed

    private void bairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bairroActionPerformed

    private void telefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefoneActionPerformed

    private void numeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numeroActionPerformed
        
    }//GEN-LAST:event_numeroActionPerformed

    private void complementoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_complementoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            confirmar.doClick();
        }
    }//GEN-LAST:event_complementoKeyPressed

    private void bairroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bairroKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            confirmar.doClick();
        }
    }//GEN-LAST:event_bairroKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PaginaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaginaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaginaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaginaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarNovoCliente().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ano;
    private javax.swing.JTextPane avisos;
    private javax.swing.JTextField bairro;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField cep;
    private javax.swing.JTextField cidade;
    private javax.swing.JTextField complemento;
    private javax.swing.JButton confirmar;
    private javax.swing.JPasswordField confirmarSenha;
    private javax.swing.JTextField cpf;
    private javax.swing.JComboBox dia;
    private javax.swing.JTextField email;
    private javax.swing.JTextField estado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField logradouro;
    private javax.swing.JComboBox mes;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField nomeUsuario;
    private javax.swing.JTextField numero;
    private javax.swing.JTextField rg;
    private javax.swing.JPasswordField senha;
    private javax.swing.JComboBox sexo;
    private javax.swing.JTextField telefone;
    // End of variables declaration//GEN-END:variables
}