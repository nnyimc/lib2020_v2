package presentation;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.border.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import beans.BeanLivre;
import entities.MotCle;
import entities.SousTheme;
import entities.Theme;

public class jCommande extends javax.swing.JFrame {

    public jCommande() {
        initComponents();
    }

    //Remplissage de la comboBox Livre
    private DefaultComboBoxModel comboLivre() {
        return new DefaultComboBoxModel(livreVector());
    }

    private Vector livreVector() {
        Vector v = new Vector();

        //Recherche du driver MSSQL
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            System.err.println("Oops:Driver:" + ex.getMessage());
            return v;
        }

        Connection connexion = null;

        //Ouverture d'une connexion vers la base de données
        try {
            connexion = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;"
                            + "databaseName=LIBGRP1;user=sa;password=u!qu!0rr4");
        } catch (SQLException ex) {
            System.err.println("Oops:Connection:" + ex.getErrorCode() + ":" + ex.getMessage());
            return v;
        }

        //Exécution d'une requête SQL
        String query = "SELECT * FROM LIVRE;";
        try {
            Statement stmt = connexion.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            //Parcours du ResultSet
            while (rs.next()) {
                v.add(new BeanLivre(rs.getString("LIVREISBN"),
                        rs.getInt("TVACODE"),
                        rs.getInt("EVENCODE"),
                        rs.getString("REPDATE"),
                        rs.getInt("EMPLOYEID"),
                        rs.getString("LIVRETITRE"),
                        rs.getString("LIVRESSTITRE"),
                        rs.getDouble("LIVREPRIXHT"),
                        rs.getString("LIVRERESUME"),
                        rs.getString("LIVRECOUV"),
                        rs.getString("LIVRESTATUT"),
                        rs.getInt("CATCODE"),
                        rs.getInt("EDITCODE")));
            }

            //Fermeture des ressources
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + ":" + ex.getMessage());
            return v;
        }

        //Fermeture de la connexion
        try {
            connexion.close();
        } catch (SQLException ex) {
            System.err.println("Oops:Close:" + ex.getErrorCode() + ":" + ex.getMessage());
            return v;
        }
        return v;
    }

    //Remplissage de la comboBox MotCle
    private DefaultComboBoxModel modelMotCle() {
        return new DefaultComboBoxModel(MotCleVector());
    }

    //Instanciation du Vector -- Liste abstraite
    private Vector MotCleVector() {
        Vector vv = new Vector();

        //Recherche du driver MSSQL
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            System.err.println("Oops:Driver:" + ex.getMessage());
            return vv;
        }

        Connection connexion = null;

        //Ouverture de la connexion vers MSSQL
        try {
            connexion = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;"
                            + "databaseName=LIBGRP1;user=sa;password=u!qu!0rr4");
        } catch (SQLException ex) {
            System.err.println("Oops:Connection:" + ex.getErrorCode() + ":" + ex.getMessage());
            return vv;
        }

        String query = "SELECT DISTINCT MOT.MOTCLEID, MOTCLEDESIGN FROM LIVRE JOIN CARACTERISER CARAC ON CARAC.LIVREISBN = LIVRE.LIVREISBN JOIN MOT_CLE MOT ON CARAC.MOTCLEID = MOT.MOTCLEID;";

        //Execution de la requête
        try {
            Statement stmt = connexion.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                vv.add(new MotCle(rs.getInt("MOTCLEID"),
                        rs.getString("MOTCLEDESIGN")));
            }
            //Fermeture des ressources
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + ":" + ex.getMessage());
            return vv;
        }

        //Fermeture de la connexion
        try {
            connexion.close();
        } catch (SQLException ex) {
            System.err.println("Oops:Close:" + ex.getErrorCode() + ":" + ex.getMessage());
            return vv;
        }

        return vv;
    }

    private DefaultComboBoxModel modelTheme() {
        return new DefaultComboBoxModel(ThemeVector());
    }
    private Vector ThemeVector() {
        Vector vvv = new Vector();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            System.err.println("Oops:Driver:" + ex.getMessage());
            return vvv;
        }
        Connection connexion = null;
        try {
            connexion = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;"
                            + "databaseName=LIBGRP1;user=sa;password=u!qu!0rr4");
        } catch (SQLException ex) {
            System.err.println("Oops:Connection:" + ex.getErrorCode() + ":" + ex.getMessage());
            return vvv;
        }

        String query ="SELECT DISTINCT THEME.THEMECODE, THEMELIBELLE FROM LIVRE JOIN SUBDIVISER SUB ON SUB.LIVREISBN = LIVRE.LIVREISBN JOIN THEME ON THEME.THEMECODE = SUB.THEMECODE;";
        try {
            Statement stmt = connexion.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                vvv.add(new Theme(rs.getInt("THEMECODE"),
                        rs.getString("THEMELIBELLE")).getNom());
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + ":" + ex.getMessage());
            return vvv;
        }
        try {
            connexion.close();
        } catch (SQLException ex) {
            System.err.println("Oops:Close:" + ex.getErrorCode() + ":" + ex.getMessage());
            return vvv;
        }
        return vvv;
    }

    private DefaultComboBoxModel modelSTheme() {
        return new DefaultComboBoxModel(SThemeVector());
    }

    private Vector SThemeVector() {
        Vector vvv = new Vector();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            System.err.println("Oops:Driver:" + ex.getMessage());
            return vvv;
        }
        Connection connexion = null;
        try {
            connexion = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;"
                            + "databaseName=LIBGRP1;user=sa;password=u!qu!0rr4");
        } catch (SQLException ex) {
            System.err.println("Oops:Connection:" + ex.getErrorCode() + ":" + ex.getMessage());
            return vvv;
        }

        String query = "SELECT DISTINCT SST.SSTHEMECODE, SSTHEMELIBELLE FROM LIVRE JOIN LIER ON LIER.LIVREISBN = LIVRE.LIVREISBN JOIN SOUS_THEME SST ON SST.SSTHEMECODE = LIER.SSTHEMECODE;";
        try {
            Statement stmt = connexion.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                vvv.add(new SousTheme(rs.getInt("SSTHEMECODE"),
                        rs.getString("SSTHEMELIBELLE")).getNom());
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + ":" + ex.getMessage());
            return vvv;
        }
        try {
            connexion.close();
        } catch (SQLException ex) {
            System.err.println("Oops:Close:" + ex.getErrorCode() + ":" + ex.getMessage());
            return vvv;
        }
        return vvv;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // Generated using JFormDesigner Evaluation license - Patrice Bal
    private void initComponents() {
        panelDetailsLivre = new JPanel();
        jLabel2 = new JLabel();
        jLabel4 = new JLabel();
        jLabel1 = new JLabel();
        jLabel3 = new JLabel();
        jTextField1 = new JTextField();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        jLabel11 = new JLabel();
        jLabel12 = new JLabel();
        comboMotCle = new JComboBox();
        comboTitre = new JComboBox();
        comboTheme = new JComboBox();
        comboSSTheme = new JComboBox();
        btnAfficherOK = new JButton();
        panelModeRech = new JPanel();
        btnRechMotCle = new JRadioButton();
        btnRechTitre = new JRadioButton();
        btnRechTheme = new JRadioButton();
        btnRechSSTheme = new JRadioButton();
        jButton1 = new JButton();
        btnAjoutPanier = new JButton();
        jColorChooser1 = new JColorChooser();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(Color.white);
        setSize(new Dimension(500, 500));
        JPanel contentPane = (JPanel) getContentPane();
        contentPane.setLayout(null);

        //======== panelDetailsLivre ========
        {
            panelDetailsLivre.setBackground(Color.white);
            panelDetailsLivre.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.
                    border.EmptyBorder(0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax.swing.border.TitledBorder.CENTER
                    ,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog",java.awt.Font
                    .BOLD,12),java.awt.Color.red),panelDetailsLivre. getBorder()));panelDetailsLivre. addPropertyChangeListener(
                new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062ord\u0065r"
                        .equals(e.getPropertyName()))throw new RuntimeException();}});
            panelDetailsLivre.setLayout(null);
            panelDetailsLivre.add(jLabel2);
            jLabel2.setBounds(330, 50, 230, 40);

            //---- jLabel4 ----
            jLabel4.setBorder(new EmptyBorder(1, 1, 1, 1));
            panelDetailsLivre.add(jLabel4);
            jLabel4.setBounds(330, 140, 230, 40);

            //---- jLabel1 ----
            jLabel1.setFont(new Font("Tahoma", Font.PLAIN, 18));
            panelDetailsLivre.add(jLabel1);
            jLabel1.setBounds(330, 10, 390, 40);

            //---- jLabel3 ----
            jLabel3.setBackground(Color.white);
            panelDetailsLivre.add(jLabel3);
            jLabel3.setBounds(330, 90, 240, 40);

            //---- jTextField1 ----
            jTextField1.setText("Resume");
            panelDetailsLivre.add(jTextField1);
            jTextField1.setBounds(10, 180, 710, 180);

            //---- jLabel9 ----
            jLabel9.setFont(new Font("Tahoma", Font.PLAIN, 10));
            jLabel9.setText("TITRE");
            panelDetailsLivre.add(jLabel9);
            jLabel9.setBounds(210, 20, 40, jLabel9.getPreferredSize().height);

            //---- jLabel10 ----
            jLabel10.setText("ISBN");
            panelDetailsLivre.add(jLabel10);
            jLabel10.setBounds(new Rectangle(new Point(210, 60), jLabel10.getPreferredSize()));

            //---- jLabel11 ----
            jLabel11.setText("PRIX");
            panelDetailsLivre.add(jLabel11);
            jLabel11.setBounds(210, 94, 30, 30);

            //---- jLabel12 ----
            jLabel12.setText("DISPONIBILITE");
            panelDetailsLivre.add(jLabel12);
            jLabel12.setBounds(new Rectangle(new Point(210, 150), jLabel12.getPreferredSize()));

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panelDetailsLivre.getComponentCount(); i++) {
                    Rectangle bounds = panelDetailsLivre.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panelDetailsLivre.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panelDetailsLivre.setMinimumSize(preferredSize);
                panelDetailsLivre.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panelDetailsLivre);
        panelDetailsLivre.setBounds(210, 20, 730, 410);

        //---- comboMotCle ----
        comboMotCle.setModel(modelMotCle());
        comboMotCle.addFocusListener(new FocusAdapter() {
        });
        comboMotCle.addActionListener(e -> comboMotCleActionPerformed(e));
        contentPane.add(comboMotCle);
        comboMotCle.setBounds(20, 240, 180, comboMotCle.getPreferredSize().height);

        //---- comboTitre ----
        comboTitre.setModel(comboLivre());
        comboTitre.setBackground(new Color(249, 249, 249));
        comboTitre.setForeground(new Color(255, 0, 51));
        comboTitre.setToolTipText("Choisissez un titre.");
        contentPane.add(comboTitre);
        comboTitre.setBounds(20, 180, 180, comboTitre.getPreferredSize().height);

        //---- comboTheme ----
        comboTheme.setModel(modelTheme());
        contentPane.add(comboTheme);
        comboTheme.setBounds(20, 310, 180, comboTheme.getPreferredSize().height);

        //---- comboSSTheme ----
        comboSSTheme.setModel(modelSTheme());
        contentPane.add(comboSSTheme);
        comboSSTheme.setBounds(20, 370, 180, comboSSTheme.getPreferredSize().height);

        //---- btnAfficherOK ----
        btnAfficherOK.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnAfficherOK.setText("OK");
        btnAfficherOK.addActionListener(e -> btnAfficherOKActionPerformed(e));
        contentPane.add(btnAfficherOK);
        btnAfficherOK.setBounds(20, 470, 170, 40);

        //======== panelModeRech ========
        {

            //---- btnRechMotCle ----
            btnRechMotCle.setText("Chercher par Mot-cl\u00e9");

            //---- btnRechTitre ----
            btnRechTitre.setText("Chercher par Titre");

            //---- btnRechTheme ----
            btnRechTheme.setText("Chercher par Theme");

            //---- btnRechSSTheme ----
            btnRechSSTheme.setText("Chercher par Sous Theme");

            //---- jButton1 ----
            jButton1.setText("Confirmer");
            jButton1.addActionListener(e -> jButton1ActionPerformed(e));

            GroupLayout panelModeRechLayout = new GroupLayout(panelModeRech);
            panelModeRech.setLayout(panelModeRechLayout);
            panelModeRechLayout.setHorizontalGroup(
                    panelModeRechLayout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panelModeRechLayout.createSequentialGroup()
                                    .addContainerGap(14, Short.MAX_VALUE)
                                    .addGroup(panelModeRechLayout.createParallelGroup()
                                            .addComponent(btnRechMotCle, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnRechTitre, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnRechTheme, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnRechSSTheme, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
                                    .addContainerGap())
                            .addGroup(panelModeRechLayout.createSequentialGroup()
                                    .addGap(51, 51, 51)
                                    .addComponent(jButton1)
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            panelModeRechLayout.setVerticalGroup(
                    panelModeRechLayout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panelModeRechLayout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(btnRechMotCle)
                                    .addGap(7, 7, 7)
                                    .addComponent(btnRechTitre)
                                    .addGap(7, 7, 7)
                                    .addComponent(btnRechTheme)
                                    .addGap(7, 7, 7)
                                    .addComponent(btnRechSSTheme)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButton1)
                                    .addGap(347, 347, 347))
            );
        }
        contentPane.add(panelModeRech);
        panelModeRech.setBounds(10, 10, 190, 170);

        //---- btnAjoutPanier ----
        btnAjoutPanier.setBackground(new Color(255, 146, 64));
        btnAjoutPanier.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnAjoutPanier.setText("Ajouter au panier");
        contentPane.add(btnAjoutPanier);
        btnAjoutPanier.setBounds(670, 490, 270, 60);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        setSize(967, 601);
        setLocationRelativeTo(getOwner());

        //---- buttonGroup1 ----
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(btnRechMotCle);
        buttonGroup1.add(btnRechTitre);
        buttonGroup1.add(btnRechTheme);
        buttonGroup1.add(btnRechSSTheme);
    }// </editor-fold>//GEN-END:initComponents

    //Actions à effectuer lorsque le bouton OK détecte un évènement
    private void btnAfficherOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAfficherOKActionPerformed

        BeanLivre l = (BeanLivre) comboTitre.getSelectedItem();
        jLabel1.setText(" " + l.getLivreTitre() + "  " + l.getLivreStatut());
        jLabel2.setText(" " + l.getLivreIsbn());
        jTextField1.setText(" " + l.getLivreResume());
        jLabel3.setText(" " + l.getLivrePrixHt());
        jLabel4.setText(" " + l.getLivreStatut());
        panelDetailsLivre.setVisible(true);


    }//GEN-LAST:event_btnAfficherOKActionPerformed

    private void comboMotCleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMotCleActionPerformed
        MotCle mc = (MotCle) comboMotCle.getSelectedItem();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            System.err.println("Oops:Driver:" + ex.getMessage());
        }
        Connection connexion = null;
        try {
            connexion = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;"
                            + "databaseName=LIBGRP1;user=sa;password=u!qu!0rr4");
        } catch (SQLException ex) {
            System.err.println("Oops:Connection:" + ex.getErrorCode() + ":" + ex.getMessage());
        }

        String query = "SELECT LIVRE.LIVRETITRE FROM LIVRE WHERE LIVRE.LIVREISBN=(SELECT CARACTERISER.LIVREISBN FROM CARACTERISER WHERE CARACTERISER.MOTCLEID= 5)  ";

        try {
            Statement stmt = connexion.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                //  jLabel13.setText(rs.getString("LIVREISBN"));
                // jComboBox1.setToolTipText(rs.getString("LIVRETITRE"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + ":" + ex.getMessage());

        }
        try {
            connexion.close();
        } catch (SQLException ex) {
            System.err.println("Oops:Close:" + ex.getErrorCode() + ":" + ex.getMessage());

        }



    }//GEN-LAST:event_comboMotCleActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(btnRechMotCle.isSelected()){
            comboMotCle.setVisible(true);
            comboTitre.setVisible(false);
            comboSSTheme.setVisible(false);
            comboTheme.setVisible(false);
        }

        if(btnRechTitre.isSelected()){
            comboSSTheme.setVisible(false);
            comboTheme.setVisible(false);
            comboMotCle.setVisible(false);
            comboTitre.setVisible(true);
        }

        if(btnRechSSTheme.isSelected()){
            comboTheme.setVisible(false);
            comboTitre.setVisible(false);
            comboMotCle.setVisible(false);
            comboSSTheme.setVisible(true);
        }

        if(btnRechTheme.isSelected()){
            comboSSTheme.setVisible(false);
            comboTitre.setVisible(false);
            comboMotCle.setVisible(false);
            comboTheme.setVisible(true);
        }

    }//GEN-LAST:event_jButton1ActionPerformed


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(jCommande.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jCommande.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jCommande.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jCommande.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jCommande().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Patrice Bal
    private JPanel panelDetailsLivre;
    private JLabel jLabel2;
    private JLabel jLabel4;
    private JLabel jLabel1;
    private JLabel jLabel3;
    private JTextField jTextField1;
    private JLabel jLabel9;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JComboBox comboMotCle;
    private JComboBox comboTitre;
    private JComboBox comboTheme;
    private JComboBox comboSSTheme;
    private JButton btnAfficherOK;
    private JPanel panelModeRech;
    private JRadioButton btnRechMotCle;
    private JRadioButton btnRechTitre;
    private JRadioButton btnRechTheme;
    private JRadioButton btnRechSSTheme;
    private JButton jButton1;
    private JButton btnAjoutPanier;
    private JColorChooser jColorChooser1;
    // End of variables declaration//GEN-END:variables
}
