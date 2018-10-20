package br.com.projeto.GUI;


import br.com.projeto.conexao.ConexaoBanco;
import br.com.projeto.entidades.Autor;
import br.com.projeto.entidades.Contato;
import br.com.projeto.entidades.Editora;
import br.com.projeto.entidades.Genero;
import br.com.projeto.entidades.Livro;
import br.com.projeto.interfaces.ContatoDao;
import br.com.projeto.interfaces.EditoraDao;
import br.com.projeto.interfacesImpl.AcervoDaoImpl;
import br.com.projeto.interfacesImpl.AutorDaoImpl;
import br.com.projeto.interfacesImpl.ContatoDaoImpl;
import br.com.projeto.interfacesImpl.EditoraDaoImpl;
import br.com.projeto.interfacesImpl.GeneroDaoImpl;
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
public class CadastrarNovoItemNoAcervo extends javax.swing.JFrame {

    /**
     * Creates new form Acervo
     */
    public CadastrarNovoItemNoAcervo() {
        initComponents();

        try {
            Image icon = Toolkit.getDefaultToolkit().getImage("src\\Imagens\\images.png");
            setIconImage(icon);

        } catch (Exception e) {
            e.printStackTrace();
        }
        setSize(1005, 492);
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

        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        avisos = new javax.swing.JTextPane();
        quantidade = new javax.swing.JTextField();
        autor = new javax.swing.JTextField();
        editora = new javax.swing.JTextField();
        nome = new javax.swing.JTextField();
        confirmar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        edicao = new javax.swing.JTextField();
        genero = new javax.swing.JTextField();
        volume = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        telefoneEditora = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        emailEditora = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        ano = new javax.swing.JComboBox();
        tituloOrignal = new javax.swing.JTextField();
        isbn = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Magnoteca");
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Linux Libertine G", 0, 24)); // NOI18N
        jLabel1.setText("NOVO ITEM NO ACERVO");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(320, 30, 370, 40);

        jLabel2.setFont(new java.awt.Font("Linux Libertine G", 0, 18)); // NOI18N
        jLabel2.setText("Titulo:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(180, 130, 130, 24);

        jLabel3.setFont(new java.awt.Font("Linux Libertine G", 0, 18)); // NOI18N
        jLabel3.setText("Editora:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(170, 290, 90, 24);

        jLabel4.setFont(new java.awt.Font("Linux Libertine G", 0, 18)); // NOI18N
        jLabel4.setText("Autor:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(330, 250, 80, 24);

        jLabel6.setFont(new java.awt.Font("Linux Libertine G", 0, 18)); // NOI18N
        jLabel6.setText("Quantidade:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(550, 210, 110, 24);

        avisos.setForeground(new java.awt.Color(255, 0, 0));
        avisos.setCaretColor(new java.awt.Color(255, 0, 0));
        avisos.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        avisos.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        avisos.setFocusCycleRoot(false);
        avisos.setFocusable(false);
        jScrollPane3.setViewportView(avisos);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(790, 300, 180, 80);

        quantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantidadeActionPerformed(evt);
            }
        });
        quantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                quantidadeKeyPressed(evt);
            }
        });
        getContentPane().add(quantidade);
        quantidade.setBounds(660, 210, 100, 30);

        autor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autorActionPerformed(evt);
            }
        });
        getContentPane().add(autor);
        autor.setBounds(390, 250, 150, 30);

        editora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editoraActionPerformed(evt);
            }
        });
        getContentPane().add(editora);
        editora.setBounds(240, 290, 200, 30);
        getContentPane().add(nome);
        nome.setBounds(240, 130, 520, 30);

        confirmar.setFont(new java.awt.Font("Centaur", 0, 11)); // NOI18N
        confirmar.setText("Confirmar");
        confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarActionPerformed(evt);
            }
        });
        getContentPane().add(confirmar);
        confirmar.setBounds(810, 400, 76, 34);

        cancelar.setFont(new java.awt.Font("Centaur", 0, 12)); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(cancelar);
        cancelar.setBounds(900, 400, 76, 34);

        jLabel7.setFont(new java.awt.Font("Linux Libertine G", 0, 18)); // NOI18N
        jLabel7.setText("Edição:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(390, 210, 90, 24);
        getContentPane().add(edicao);
        edicao.setBounds(460, 210, 80, 30);

        genero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generoActionPerformed(evt);
            }
        });
        getContentPane().add(genero);
        genero.setBounds(620, 250, 140, 30);
        getContentPane().add(volume);
        volume.setBounds(240, 210, 140, 30);

        jLabel11.setFont(new java.awt.Font("Linux Libertine G", 0, 18)); // NOI18N
        jLabel11.setText("Gênero:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(550, 250, 100, 24);

        jLabel10.setFont(new java.awt.Font("Linux Libertine G", 0, 18)); // NOI18N
        jLabel10.setText("Ano:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(200, 250, 80, 24);

        jLabel5.setFont(new java.awt.Font("Linux Libertine G", 0, 18)); // NOI18N
        jLabel5.setText("Título Original:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(110, 170, 200, 24);

        telefoneEditora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefoneEditoraActionPerformed(evt);
            }
        });
        getContentPane().add(telefoneEditora);
        telefoneEditora.setBounds(600, 290, 160, 30);

        jLabel8.setFont(new java.awt.Font("Linux Libertine G", 0, 18)); // NOI18N
        jLabel8.setText("Telefone Editora:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(450, 290, 180, 24);

        emailEditora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailEditoraActionPerformed(evt);
            }
        });
        getContentPane().add(emailEditora);
        emailEditora.setBounds(240, 330, 170, 30);

        jLabel12.setFont(new java.awt.Font("Linux Libertine G", 0, 18)); // NOI18N
        jLabel12.setText("Email Editora:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(120, 330, 180, 24);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/MarcadorBG.jpg"))); // NOI18N
        getContentPane().add(jLabel14);
        jLabel14.setBounds(840, -10, 85, 290);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Logo.jpg"))); // NOI18N
        getContentPane().add(jLabel15);
        jLabel15.setBounds(20, 380, 320, 70);

        ano.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2015","2014","2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921", "1920", "1919", "1918", "1917", "1916", "1915", "1914", "1913" }));
        ano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anoActionPerformed(evt);
            }
        });
        getContentPane().add(ano);
        ano.setBounds(240, 250, 80, 30);

        tituloOrignal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tituloOrignalActionPerformed(evt);
            }
        });
        getContentPane().add(tituloOrignal);
        tituloOrignal.setBounds(240, 170, 260, 30);

        isbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isbnActionPerformed(evt);
            }
        });
        getContentPane().add(isbn);
        isbn.setBounds(559, 170, 200, 30);

        jLabel17.setFont(new java.awt.Font("Linux Libertine G", 0, 18)); // NOI18N
        jLabel17.setText("ISBN:");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(510, 170, 110, 20);

        jLabel18.setFont(new java.awt.Font("Linux Libertine G", 0, 18)); // NOI18N
        jLabel18.setText("Volume:");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(170, 210, 110, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editoraActionPerformed

    private void confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarActionPerformed
        String tituloV = nome.getText();
        String volumeV1 = volume.getText();
        String anoV1 = (String) ano.getSelectedItem();
        String editoraV = editora.getText();
        String telefoneEditoraV = telefoneEditora.getText();
        String emailEditoraV = emailEditora.getText();
        String autorV = autor.getText();
        String quantidadeV1 = quantidade.getText();
        String edicaoV1 = edicao.getText();
        String isbnV = isbn.getText();
        String titulo_Original = tituloOrignal.getText();
        String generoV = genero.getText();
        int volumeV = Integer.parseInt(volumeV1);
        int anoV = Integer.parseInt(anoV1);
        int quantidadeV = Integer.parseInt(quantidadeV1);
        int edicaoV = Integer.parseInt(edicaoV1);
        
        boolean dadosErrados = false;
        
        if (tituloV.equals("") || volumeV1.equals("") || anoV1.equals("") || editoraV.equals("") || 
                autorV.equals("") ||  quantidadeV1.equals("") || edicaoV1.equals("") || isbnV.equals("") || 
                titulo_Original.equals("") || generoV.equals("")) {       
            avisos.setText(avisos.getText() + "- Nenhum dos campos podem ficar em branco\n");
            dadosErrados = true;
         }
        
        if(dadosErrados == false){
            Genero generoObj = new Genero(generoV);
            GeneroDaoImpl generoDaoImpl = new GeneroDaoImpl(ConexaoBanco.getConnection());
            
            int idGeneroBuscado = generoDaoImpl.buscarIdGenero(generoV);
            if(idGeneroBuscado == 0){
                int idGenero = generoDaoImpl.persitir(generoObj);
                generoObj.setId(idGenero);
            } else{
                generoObj.setId(idGeneroBuscado);
            }

            Autor autorObj = new Autor(autorV);
            AutorDaoImpl autorDaoImpl = new AutorDaoImpl(ConexaoBanco.getConnection());
            int idAutorBuscado = autorDaoImpl.buscarId(autorV);
            if(idAutorBuscado == 0){
                int idAutor = autorDaoImpl.persistir(autorObj);
                autorObj.setId(idAutor);
            } else{
                autorObj.setId(idAutorBuscado);
            }
            
            Editora editora = new Editora(editoraV);
            EditoraDao editoraDao = new EditoraDaoImpl(ConexaoBanco.getConnection());
            int idEditoraBuscado = editoraDao.buscarId(editoraV);
            if(idEditoraBuscado == 0){
                int idEditora = editoraDao.persitir(editora);
                editora.setId(idEditora);
                
                Contato contato = new Contato(telefoneEditoraV, emailEditoraV);
                ContatoDao contatoDao = new ContatoDaoImpl(ConexaoBanco.getConnection());
                int idContato = contatoDao.persitir(contato);
                contato.setId(idContato);
                
                contatoDao.adicionarEditoraTelefone(editora.getId(), contato.getId());
            } else{
                editora.setId(idEditoraBuscado);
            }

            Livro livro = new Livro(tituloV, titulo_Original, isbnV, volumeV, anoV, edicaoV, quantidadeV, generoObj, autorObj, editora);
            AcervoDaoImpl acervoDaoImpl = new AcervoDaoImpl(ConexaoBanco.getConnection());
            int idLivro = acervoDaoImpl.persistir(livro);
            livro.setId(idLivro);
            
            autorDaoImpl.adicionarAutorLivro(autorObj.getId(), livro.getId());

            try {
                ConexaoBanco.getConnection().commit();
                JOptionPane.showMessageDialog(this, "Livro Cadastrado com Sucesso");
                dispose();
            } catch (SQLException ex) {
                Logger.getLogger(CadastrarNovoItemNoAcervo.class.getName()).log(Level.SEVERE, null, ex);
                try {
                    ConexaoBanco.getConnection().rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(CadastrarNovoItemNoAcervo.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
            dispose();
        }
            
    }//GEN-LAST:event_confirmarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
       
        dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void autorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_autorActionPerformed

    private void quantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantidadeActionPerformed

    private void quantidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantidadeKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            confirmar.doClick();
        }
    }//GEN-LAST:event_quantidadeKeyPressed

    private void generoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_generoActionPerformed

    private void telefoneEditoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefoneEditoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefoneEditoraActionPerformed

    private void anoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_anoActionPerformed

    private void isbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isbnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isbnActionPerformed

    private void tituloOrignalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tituloOrignalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tituloOrignalActionPerformed

    private void emailEditoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailEditoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailEditoraActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ano;
    private javax.swing.JTextField autor;
    private javax.swing.JTextPane avisos;
    private javax.swing.JButton cancelar;
    private javax.swing.JButton confirmar;
    private javax.swing.JTextField edicao;
    private javax.swing.JTextField editora;
    private javax.swing.JTextField emailEditora;
    private javax.swing.JTextField genero;
    private javax.swing.JTextField isbn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField quantidade;
    private javax.swing.JTextField telefoneEditora;
    private javax.swing.JTextField tituloOrignal;
    private javax.swing.JTextField volume;
    // End of variables declaration//GEN-END:variables
}