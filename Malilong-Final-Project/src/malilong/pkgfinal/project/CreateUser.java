/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package malilong.pkgfinal.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class CreateUser extends javax.swing.JFrame {

    private String user;
    private String accname;
    private String contacts;
    private String passwords;
    private int Vcheck = 0;

    LocalDateTime now = LocalDateTime.now();
    String formatted = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    public CreateUser() {
        initComponents();
    }

    private void Savedata(String AccountUsername, String AccountPassword, String AccountName, String AccountContact) {
        DBconnection.init();
        try {

            Connection c = DBconnection.getConnection();

            PreparedStatement checkUser = c.prepareStatement("SELECT * FROM accounts WHERE username = ?");
            checkUser.setString(1, AccountUsername);
            ResultSet rs = checkUser.executeQuery();

            if (rs.next()) {
                Vcheck = 1;
                JOptionPane.showMessageDialog(null, "Username already exists! Please choose another one.");
                return;

            }

            PreparedStatement insertAccount = c.prepareStatement(
                    "INSERT INTO accounts (username, Password, name, contact) VALUES (?, ?, ?, ?)"
            );
            insertAccount.setString(1, AccountUsername);
            insertAccount.setString(2, AccountPassword);
            insertAccount.setString(3, AccountName);
            insertAccount.setString(4, AccountContact);
            insertAccount.executeUpdate();

            PreparedStatement createTable = c.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS `" + AccountUsername + "` ("
                    + "id INT NOT NULL AUTO_INCREMENT, "
                    + "dates VARCHAR(125), "
                    + "reference VARCHAR(125), "
                    + "title VARCHAR(125), "
                    + "notes VARCHAR(125), "
                    + "remarks VARCHAR(125), "
                    + "PRIMARY KEY (id))"
            );
            createTable.executeUpdate();
            JOptionPane.showMessageDialog(null, "Account Successfully Created");
            Vcheck = 0;

        } catch (SQLException ex) {
            ex.printStackTrace(); // for debugging
            JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage());

        }
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
        username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        FullName = new javax.swing.JTextField();
        contact = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        userpasswordf = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(580, 450));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Create Account");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 310, -1));
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 370, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));
        getContentPane().add(FullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 370, -1));
        getContentPane().add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 370, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Contact");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Password");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));
        getContentPane().add(userpasswordf, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 370, -1));

        jButton1.setBackground(new java.awt.Color(51, 102, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, -1));

        jButton2.setBackground(new java.awt.Color(204, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/malilong/pkgfinal/project/pic 9.jpg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        user = username.getText();
        accname = FullName.getText();
        passwords = userpasswordf.getText();
        contacts = contact.getText();
        if (user.equals("") || accname.equals("") || passwords.equals("") || contacts.equals("")) {
            JOptionPane.showMessageDialog(null, "Fill the form completely!");
        } else {
            Savedata(user, passwords, accname, contacts);
            if (Vcheck == 0) {
                Librarian open = new Librarian();
                open.setVisible(true);
                this.dispose();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Librarian open = new Librarian();
        open.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField FullName;
    private javax.swing.JTextField contact;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField username;
    private javax.swing.JTextField userpasswordf;
    // End of variables declaration//GEN-END:variables
}
