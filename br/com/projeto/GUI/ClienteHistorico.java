package br.com.projeto.GUI;


import br.com.projeto.conexao.ConexaoBanco;
import br.com.projeto.entidades.Cliente;
import br.com.projeto.entidades.Emprestimo;
import br.com.projeto.interfaces.EmprestimoDao;
import br.com.projeto.interfacesImpl.EmprestimoDaoImpl;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rafael Cardozo
 */
public class ClienteHistorico extends javax.swing.JFrame {
    
    
    /**
     * Creates new form Historico
     */
    public ClienteHistorico(Cliente umCliente){
        initComponents();

        try {
            Image icon = Toolkit.getDefaultToolkit().getImage("src\\Imagens\\images.png");
            setIconImage(icon);

        } catch (Exception e) {
            e.printStackTrace();
        }
        

        setSize(678, 489);
        this.getContentPane().setBackground(Color.WHITE);
        
        EmprestimoDao emprestimoDao = new EmprestimoDaoImpl(ConexaoBanco.getConnection());
        List<Emprestimo> emprestimos = emprestimoDao.buscarEmprestimos(umCliente);
        
        if(emprestimos.isEmpty()){
            JOptionPane.showMessageDialog(this, "Você não tem empréstimos anteriores!");
        } else{
            for (Emprestimo emprestimo : emprestimos) {
                addLinha(emprestimo);
            }
        }
        
    }
    
    public ClienteHistorico(){
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
    
    private void addLinha(Emprestimo umEmprestimo) {
        Object[] linha = new Object[3];
        linha[0] = umEmprestimo.getLivro().getTitulo();
        linha[1] = umEmprestimo.getData_Emprestimo();
        linha[2] = umEmprestimo.getData_Devolucao();
        DefaultTableModel modelo = (DefaultTableModel) dadosEmprestimos.getModel();
        modelo.addRow(linha);
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
        confirmar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dadosEmprestimos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Magnoteca");
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Linux Libertine G", 0, 24)); // NOI18N
        jLabel1.setText("HISTÓRICO");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(260, 20, 140, 32);

        confirmar.setFont(new java.awt.Font("Centaur", 0, 14)); // NOI18N
        confirmar.setText("Voltar");
        confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarActionPerformed(evt);
            }
        });
        confirmar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                confirmarKeyPressed(evt);
            }
        });
        getContentPane().add(confirmar);
        confirmar.setBounds(570, 410, 76, 34);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/MarcadorBG.jpg"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(550, -10, 85, 290);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Logo.jpg"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 380, 320, 70);

        dadosEmprestimos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Livro", "Data do empréstimo", "Data de entrega"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(dadosEmprestimos);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(100, 60, 450, 310);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarActionPerformed
        dispose();
    }//GEN-LAST:event_confirmarActionPerformed

    private void confirmarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_confirmarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            confirmar.doClick();
        }
    }//GEN-LAST:event_confirmarKeyPressed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confirmar;
    private javax.swing.JTable dadosEmprestimos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
