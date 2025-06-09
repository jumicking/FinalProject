package malilong.pkgfinal.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class User extends javax.swing.JFrame {

    private String username;
    DefaultTableModel model;

    public User() {
        initComponents();
    }

    public User(String Name) {
        initComponents();
        model = (DefaultTableModel) UserTable.getModel();
        model.setRowCount(0);
        this.username = Name;
        Search();
        Tables();

    }

    public void Tables() {
        DBconnection.init();
        Connection c = DBconnection.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("SELECT * FROM " + username + " WHERE remarks = 'out'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                model.addRow(new Object[]{rs.getString("dates"), rs.getString("reference"), rs.getString("title"), rs.getString("remarks")});

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    void Search() {
        DBconnection.init();
        Connection c = DBconnection.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("SELECT * FROM accounts WHERE username = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
          if (rs.next()){  
              UserName.setText(rs.getString("name"));
          }
            }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        }

        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        UserName = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        UserTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 520));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Name:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 37, -1));

        UserName.setText("Your name");
        jPanel1.add(UserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 250, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 330, 40));

        UserTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Reference", "Date", "Title", "Remarks"
            }
        ));
        jScrollPane1.setViewportView(UserTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 510, 330));

        jLabel3.setText("Borrowed Books");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jButton1.setText("Log out");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Library open = new Library();
        open.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel UserName;
    private javax.swing.JTable UserTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
