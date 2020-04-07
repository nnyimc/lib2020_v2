package presentation;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.*;


public class jLogin extends javax.swing.JFrame {

    //Formulaire d'authentification
    public jLogin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // Generated using JFormDesigner
    private void initComponents() {
        labelTitre = new JLabel();
        sprtrTitre = new JSeparator();
        champUser = new JTextField();
        labelUser = new JLabel();
        champPass = new JPasswordField();
        labelPass = new JLabel();
        btnLogIn = new JButton();
        labelInfo = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("LIBGRP1 - Authentification");
        setBackground(new Color(204, 204, 255));
        setResizable(false);
        setSize(new Dimension(480, 200));
        addFocusListener(new FocusAdapter() {

        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                formMouseEntered(e);
            }
        });
        JPanel contentPane = (JPanel) getContentPane();
        contentPane.setLayout(null);

        //---- labelTitre ----
        labelTitre.setFont(new Font("Tahoma", Font.PLAIN, 18));
        labelTitre.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitre.setText("LIBGRP1 - Authentification");
        contentPane.add(labelTitre);
        labelTitre.setBounds(140, 20, 220, 20);
        contentPane.add(sprtrTitre);
        sprtrTitre.setBounds(0, 60, 490, 20);

        //---- champUser ----
        champUser.setFont(new Font("Tahoma", Font.BOLD, 14));
        contentPane.add(champUser);
        champUser.setBounds(230, 90, 220, 40);

        //---- labelUser ----
        labelUser.setFont(new Font("Tahoma", Font.BOLD, 12));
        labelUser.setText("USERNAME: ");
        contentPane.add(labelUser);
        labelUser.setBounds(50, 90, 120, 30);

        //---- champPass ----
        contentPane.add(champPass);
        champPass.setBounds(230, 160, 220, 40);

        //---- labelPass ----
        labelPass.setFont(new Font("Tahoma", Font.BOLD, 12));
        labelPass.setText("MOT DE PASSE:");
        contentPane.add(labelPass);
        labelPass.setBounds(50, 160, 150, 30);

        //---- btnLogIn ----
        btnLogIn.setText("LOG IN");
        btnLogIn.addActionListener(e -> btnLogInActionPerformed(e));
        contentPane.add(btnLogIn);
        btnLogIn.setBounds(170, 240, 110, 40);

        //---- labelInfo ----
        labelInfo.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(labelInfo);
        labelInfo.setBounds(10, 300, 470, 30);

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
        setSize(503, 378);
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void btnLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogInActionPerformed
        Vector v = new Vector();

        char[] passe = champPass.getPassword();
        String passString = new String(passe);

        //Verifier que le champ mdp n'est pas vide
        if (passString.equals("")) {
            labelInfo.setText("Indiquez votre mot de passe !");
            return;
        }

        //Verifier que le champ user n'est pas vide'
        if (champUser.getText().equals("")) {
            labelInfo.setText("Indiquez votre identifiant !");
            return;
        }

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            System.err.println("Oops:Driver:" + ex.getMessage());
            return;
        }

        Connection connexion = null;
        java.sql.Statement stmt;
        ResultSet rs;
        try {
            connexion = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;"
                            + "databaseName=LIBGRP1;user=sa;password=u!qu!0rr4");
        } catch (SQLException ex) {
            System.err.println("Oops:Connection:" + ex.getErrorCode() + ":" + ex.getMessage());
            return;
        }


        try {
            String query = "SELECT EMPLOYELOGIN, EMPLOYEMDP FROM EMPLOYE WHERE EMPLOYELOGIN= '" + champUser.getText() + "' AND EMPLOYEMDP= '" + passString + "';";
            System.out.print(query);
            stmt = connexion.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
            rs = stmt.executeQuery(query);


            if (!rs.isBeforeFirst()) {
                labelInfo.setText("Echec de l'authentification.");
            }

            while (rs.next()) {
                jCommande jfc = new jCommande();
                jfc.setVisible(true);

                System.out.println("Login Done!");
                this.dispose();
            }

            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + ":" + ex.getMessage());
            return;
        }
        try {
            connexion.close();
        } catch (SQLException ex) {
            System.err.println("Oops:Close:" + ex.getErrorCode() + ":" + ex.getMessage());
            return;
        }


    }//GEN-LAST:event_btnLogInActionPerformed


    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        labelInfo.setText("Tous les champs sont obligatoires.");
    }//GEN-LAST:event_formMouseEntered

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
            java.util.logging.Logger.getLogger(jLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Patrice Bal
    private JLabel labelTitre;
    private JSeparator sprtrTitre;
    private JTextField champUser;
    private JLabel labelUser;
    private JPasswordField champPass;
    private JLabel labelPass;
    private JButton btnLogIn;
    private JLabel labelInfo;
    // End of variables declaration//GEN-END:variables
}
