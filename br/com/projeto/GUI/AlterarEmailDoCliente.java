package br.com.projeto.GUI;

import br.com.projeto.conexao.ConexaoBanco;
import br.com.projeto.entidades.Contato;
import br.com.projeto.interfaces.ContatoDao;
import br.com.projeto.interfacesImpl.ContatoDaoImpl;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
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
public class AlterarEmailDoCliente extends javax.swing.JFrame {

    /**
     * Creates new form CliEmail
     */
    public AlterarEmailDoCliente() {
        initComponents();

        try {
            Image icon = Toolkit.getDefaultToolkit().getImage("src\\Imagens\\images.png");
            setIconImage(icon);

        } catch (Exception e) {
            e.printStackTrace();
        }
        setSize(678, 489);
        this.getContentPane().setBackground(Color.WHITE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        emailAntigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        voltar = new javax.swing.JToggleButton();
        emailNovo = new javax.swing.JTextField();
        confirmar = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        avisos = new javax.swing.JLabel();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Magnoteca");
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Linux Libertine G", 0, 24)); // NOI18N
        jLabel1.setText("ALTERAR E-MAIL");
        jLabel1.setToolTipText("");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(260, 80, 310, 50);
        getContentPane().add(emailAntigo);
        emailAntigo.setBounds(250, 200, 220, 30);

        jLabel3.setFont(new java.awt.Font("Linux Libertine G", 0, 18)); // NOI18N
        jLabel3.setText("Novo e-mail:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(110, 240, 140, 24);

        voltar.setFont(new java.awt.Font("Centaur", 0, 12)); // NOI18N
        voltar.setText("Voltar");
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });
        getContentPane().add(voltar);
        voltar.setBounds(530, 370, 76, 34);

        emailNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailNovoActionPerformed(evt);
            }
        });
        emailNovo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                emailNovoKeyPressed(evt);
            }
        });
        getContentPane().add(emailNovo);
        emailNovo.setBounds(250, 240, 220, 30);

        confirmar.setFont(new java.awt.Font("Centaur", 0, 11)); // NOI18N
        confirmar.setText("Confirmar");
        confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarActionPerformed(evt);
            }
        });
        getContentPane().add(confirmar);
        confirmar.setBounds(430, 370, 90, 34);

        jLabel2.setFont(new java.awt.Font("Linux Libertine G", 0, 18)); // NOI18N
        jLabel2.setText("E-mail anterior:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(110, 200, 150, 24);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/MarcadorBG.jpg"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(550, -10, 85, 290);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Logo.jpg"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 380, 320, 70);

        avisos.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(avisos);
        avisos.setBounds(250, 280, 220, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emailNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailNovoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailNovoActionPerformed

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        dispose();
    }//GEN-LAST:event_voltarActionPerformed

    private void confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarActionPerformed
        String emailAntigoV = emailAntigo.getText();
        String emailNovoV = emailNovo.getText();

        ContatoDao contatoDao = new ContatoDaoImpl(ConexaoBanco.getConnection());
        int idContato = contatoDao.buscarId(emailAntigoV);
        Contato contato = new Contato(idContato, emailNovoV);
        try {
            ConexaoBanco.getConnection().commit();
        } catch (SQLException ex) {
            Logger.getLogger(AlterarEmailDoCliente.class.getName()).log(Level.SEVERE, null, ex);
            try {
                ConexaoBanco.getConnection().rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(AlterarEmailDoCliente.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }

        boolean updateCorreto = false;
        if (idContato == 0) {
            avisos.setText("Seu email antigo está errado!");
        } else {
            updateCorreto = contatoDao.alterarDados(contato);
            try {
                ConexaoBanco.getConnection().commit();
            } catch (SQLException ex) {
                Logger.getLogger(AlterarSenhaDoClienteLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (updateCorreto) {
            JOptionPane.showMessageDialog(this, "Alteração realizada com sucesso!");
            dispose();
        }

    }//GEN-LAST:event_confirmarActionPerformed

    private void emailNovoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailNovoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            confirmar.doClick();
        }
    }//GEN-LAST:event_emailNovoKeyPressed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avisos;
    private javax.swing.JToggleButton confirmar;
    private javax.swing.JTextField emailAntigo;
    private javax.swing.JTextField emailNovo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JToggleButton voltar;
    // End of variables declaration//GEN-END:variables
}
