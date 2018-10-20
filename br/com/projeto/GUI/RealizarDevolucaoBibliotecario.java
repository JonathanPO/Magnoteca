package br.com.projeto.GUI;

import br.com.projeto.conexao.ConexaoBanco;
import br.com.projeto.entidades.Cliente;
import br.com.projeto.entidades.Emprestimo;
import br.com.projeto.entidades.Livro;
import br.com.projeto.entidades.Multa;
import br.com.projeto.interfaces.AcervoDao;
import br.com.projeto.interfaces.ClienteDao;
import br.com.projeto.interfaces.EmprestimoDao;
import br.com.projeto.interfaces.MultaDao;
import br.com.projeto.interfacesImpl.AcervoDaoImpl;
import br.com.projeto.interfacesImpl.ClienteDaoImpl;
import br.com.projeto.interfacesImpl.EmprestimoDaoImpl;
import br.com.projeto.interfacesImpl.MultaDaoImpl;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
public class RealizarDevolucaoBibliotecario extends javax.swing.JFrame {

    /**
     * Creates new form Devoluçao
     */
    public RealizarDevolucaoBibliotecario() {
        initComponents();
        try {
            Image icon = Toolkit.getDefaultToolkit().getImage("src\\Imagens\\images.png");
            setIconImage(icon);

        } catch (Exception e) {
            e.printStackTrace();
        }

        setSize(678, 480);
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

        jLabel1 = new javax.swing.JLabel();
        nomedousuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        avisos = new javax.swing.JTextPane();
        nomedolivro = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        dia = new javax.swing.JComboBox();
        mes = new javax.swing.JComboBox();
        ano = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        confirmar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Magnoteca");
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Linux Libertine G", 0, 24)); // NOI18N
        jLabel1.setText("DEVOLUÇÃO");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(240, 110, 310, 22);
        getContentPane().add(nomedousuario);
        nomedousuario.setBounds(300, 200, 220, 30);

        jLabel2.setFont(new java.awt.Font("Linux Libertine G", 0, 18)); // NOI18N
        jLabel2.setText("Nome do usuário (Cliente):");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 200, 240, 24);

        avisos.setForeground(new java.awt.Color(255, 0, 0));
        avisos.setCaretColor(new java.awt.Color(255, 0, 0));
        avisos.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        avisos.setFocusCycleRoot(false);
        avisos.setFocusable(false);
        jScrollPane3.setViewportView(avisos);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(20, 20, 140, 110);
        getContentPane().add(nomedolivro);
        nomedolivro.setBounds(300, 240, 220, 30);

        jLabel3.setFont(new java.awt.Font("Linux Libertine G", 0, 18)); // NOI18N
        jLabel3.setText("Nome do livro:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(160, 240, 160, 30);

        dia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        dia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                diaKeyPressed(evt);
            }
        });
        getContentPane().add(dia);
        dia.setBounds(300, 280, 60, 30);

        mes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
        mes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mesKeyPressed(evt);
            }
        });
        getContentPane().add(mes);
        mes.setBounds(360, 280, 70, 30);

        ano.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921", "1920", "1919", "1918", "1917", "1916", "1915", "1914", "1913" }));
        ano.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                anoKeyPressed(evt);
            }
        });
        getContentPane().add(ano);
        ano.setBounds(430, 280, 90, 30);

        jLabel5.setFont(new java.awt.Font("Linux Libertine G", 0, 18)); // NOI18N
        jLabel5.setText("Data da entrega:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(140, 280, 210, 24);

        confirmar.setFont(new java.awt.Font("Centaur", 0, 11)); // NOI18N
        confirmar.setText("Confirmar");
        confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarActionPerformed(evt);
            }
        });
        getContentPane().add(confirmar);
        confirmar.setBounds(480, 400, 76, 34);

        cancelar.setFont(new java.awt.Font("Centaur", 0, 11)); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(cancelar);
        cancelar.setBounds(580, 400, 76, 34);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/MarcadorBG.jpg"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(550, -10, 85, 290);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Logo.jpg"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 380, 320, 70);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed

        dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarActionPerformed
        String nomeUsuario = nomedousuario.getText();
        String nomeLivro = nomedolivro.getText();
        String diaString = (String) dia.getSelectedItem();
        String mesString = (String) mes.getSelectedItem();
        String anoString = (String) ano.getSelectedItem();
        int day = Integer.parseInt(diaString);
        int month = Integer.parseInt(mesString);
        int year = Integer.parseInt(anoString);
        Calendar calendar = new GregorianCalendar(year, month - 1, day);

        Date dataDevolucao = new Date(calendar.getTimeInMillis());

        ClienteDao clienteDao = new ClienteDaoImpl(ConexaoBanco.getConnection());
        Cliente cliente = clienteDao.buscarTudoCliente(nomeUsuario);

        Emprestimo emprestimo = null;
        if (cliente == null) {
            JOptionPane.showMessageDialog(this, "Nome de usuário incorreto!");
        } else {
            AcervoDao acervoDao = new AcervoDaoImpl(ConexaoBanco.getConnection());
            Livro livro = new Livro(nomeLivro);
            int idLivro = acervoDao.buscarId(livro);
            if (idLivro == 0) {
                JOptionPane.showMessageDialog(this, "Esse livro não consta no acervo!");
            } else {
                livro.setId(idLivro);

                EmprestimoDao emprestimoDao = new EmprestimoDaoImpl(ConexaoBanco.getConnection());
                emprestimo = emprestimoDao.buscarEmprestimo(livro.getId(), cliente.getId());
                emprestimo.setCliente(cliente);
                emprestimo.setLivro(livro);
                if (emprestimo == null) {
                    JOptionPane.showMessageDialog(this, "Esse empréstimo não existe!");
                } else {
                    if (dataDevolucao.after(emprestimo.getPrevisao_Devolucao())) {
                        Calendar calendar1 = new GregorianCalendar();
                        calendar1.setTimeInMillis(dataDevolucao.getTime() - emprestimo.getPrevisao_Devolucao().getTime());

                        JOptionPane.showMessageDialog(this, "Esse empréstimo tem " + calendar1.get(Calendar.DAY_OF_MONTH) + " dias de atraso!");
                        Multa multa = new Multa(calendar1.get(Calendar.DAY_OF_MONTH), emprestimo);
                        MultaDao multaDao = new MultaDaoImpl(ConexaoBanco.getConnection());
                        int idMulta = multaDao.persistir(multa);

                    }
                    emprestimo.setPrevisao_Devolucao(dataDevolucao);
                    emprestimoDao.updateEmprestimo(emprestimo);

                    try {
                        ConexaoBanco.getConnection().commit();
                        JOptionPane.showMessageDialog(this, "Devolução concluída!");
                    } catch (SQLException ex) {
                        try {
                            ConexaoBanco.getConnection().rollback();
                        } catch (SQLException ex1) {
                            Logger.getLogger(RealizarDevolucao.class.getName()).log(Level.SEVERE, null, ex1);
                        }
                        Logger.getLogger(RealizarDevolucao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        dispose();


    }//GEN-LAST:event_confirmarActionPerformed

    private void diaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_diaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            confirmar.doClick();
        }
    }//GEN-LAST:event_diaKeyPressed

    private void mesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mesKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            confirmar.doClick();
        }
    }//GEN-LAST:event_mesKeyPressed

    private void anoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_anoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            confirmar.doClick();
        }
    }//GEN-LAST:event_anoKeyPressed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ano;
    private javax.swing.JTextPane avisos;
    private javax.swing.JButton cancelar;
    private javax.swing.JButton confirmar;
    private javax.swing.JComboBox dia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox mes;
    private javax.swing.JTextField nomedolivro;
    private javax.swing.JTextField nomedousuario;
    // End of variables declaration//GEN-END:variables
}
