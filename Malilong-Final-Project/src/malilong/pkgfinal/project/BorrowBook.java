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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class BorrowBook extends javax.swing.JFrame {

    LocalDateTime now = LocalDateTime.now();
    private String formatted = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    private int verify = 0;
    private int currentborrowed = 0;
    private int updateborrowed = 0;
    private String UName;
    private String usercontact;

    public BorrowBook() {
        initComponents();
    }

    void CheckBook(String Bookreffer, String username) {
        DBconnection.init();
        try {
            verify = 0;
            Connection c = DBconnection.getConnection();
            PreparedStatement ps = c.prepareStatement("SELECT * FROM inventory WHERE bookreference = ?");
            ps.setString(1, Bookreffer);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "No book found!");
                verify = 1;
                return;

            }
            ps = c.prepareStatement("SELECT * FROM accounts WHERE username = ?");
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "No account found!");
                verify = 1;
                return;
            }

        } catch (SQLException ex) {
            ex.printStackTrace(); // for debugging
            JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage());
        }
    }

    void AddtoAccount(String Username, String BookRef, String Title, String Remarks, String Number) {
        DBconnection.init();
        verify = 0;
        try {
            Connection c = DBconnection.getConnection();

            PreparedStatement ps = c.prepareStatement(
                    "INSERT INTO " + Username + " (dates, reference, title, notes, remarks) VALUES (?, ?, ?, ?, ?)"
            );
            ps.setString(1, formatted);
            ps.setString(2, BookRef);
            ps.setString(3, Title);
            ps.setString(4, Remarks);
            ps.setString(5, "out");
            ps.executeUpdate(); // Use executeUpdate for INSERT
            ps.close();

            // Get user info
            ps = c.prepareStatement("SELECT * FROM accounts WHERE username = ?");
            ps.setString(1, Username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                UName = rs.getString("name");
                usercontact = rs.getString("contact");
            }
            rs.close();
            ps.close();

            // Insert to borrowers log
            ps = c.prepareStatement(
                    "INSERT INTO borrowerslog (date, bookreference, bookname, borrowersname, borrowerscontact, Remarks) VALUES (?, ?, ?, ?, ?, ?)"
            );
            ps.setString(1, formatted);
            ps.setString(2, BookRef);
            ps.setString(3, Title);
            ps.setString(4, UName);
            ps.setString(5, usercontact);
            ps.setString(6, "Out : "+ Number + " " + Remarks);
            int inserted = ps.executeUpdate();

            if (inserted > 0) {
                JOptionPane.showMessageDialog(null, "Transaction Successfully Saved");
            } else {
                JOptionPane.showMessageDialog(null, "ERROR!");
            }
            ps.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage());
        }
    }

    void AddtoInventory(String References, int borrowed) {
        DBconnection.init();
        try {
            Connection c = DBconnection.getConnection();
            PreparedStatement ps = c.prepareStatement("SELECT * FROM inventory WHERE bookreference = ?");
            ps.setString(1, References);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                currentborrowed = rs.getInt("borrowed");
                updateborrowed = currentborrowed + borrowed;
            } else {
                JOptionPane.showMessageDialog(null, "Book not found in inventory!");
                return;
            }

            ps = c.prepareStatement("UPDATE inventory SET borrowed = ? WHERE bookreference = ?");
            ps.setInt(1, updateborrowed);
            ps.setString(2, References);
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
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
        jLabel2 = new javax.swing.JLabel();
        BookRef = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        BookTitle = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        BUsername = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        remarks = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        NumberofBooks = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(350, 460));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Borrow a Book");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 18, 260, -1));

        jLabel2.setText("Book Reference");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));
        getContentPane().add(BookRef, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 270, -1));

        jLabel3.setText("Book Title");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));
        getContentPane().add(BookTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 270, -1));

        jLabel4.setText("Borrower's Account");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));
        getContentPane().add(BUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 270, -1));

        jLabel5.setText("Remarks");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        remarks.setColumns(20);
        remarks.setRows(5);
        jScrollPane1.setViewportView(remarks);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        jLabel6.setText("Number of books");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));
        getContentPane().add(NumberofBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 270, -1));

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String getReference = BookRef.getText();
        String getTitle = BookTitle.getText();
        String getUser = BUsername.getText();
        String getRemarks = remarks.getText();
        String getNumbers = NumberofBooks.getText();
        int getNumber = Integer.parseInt(NumberofBooks.getText());

        if (getReference.equals("") || getUser.equals("") || getTitle.equals("") || getRemarks.equals("")) {
            JOptionPane.showMessageDialog(null, "Completely fill the form with correct data!");
            return;
        } else {
            CheckBook(getReference, getUser);
            if (verify == 1) {
                JOptionPane.showMessageDialog(null, "Wrong information!");
            } else {
                AddtoAccount(getUser, getReference, getTitle, getRemarks, getNumbers);
                AddtoInventory(getReference, getNumber);
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
            java.util.logging.Logger.getLogger(BorrowBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BorrowBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BorrowBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BorrowBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BorrowBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BUsername;
    private javax.swing.JTextField BookRef;
    private javax.swing.JTextField BookTitle;
    private javax.swing.JTextField NumberofBooks;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea remarks;
    // End of variables declaration//GEN-END:variables
}
