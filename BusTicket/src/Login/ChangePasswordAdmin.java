/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Admin.Services;
import Includes.Database;
import Includes.SHA;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author HansiPC
 */
public class ChangePasswordAdmin extends javax.swing.JFrame {

    private String adminUsername;
    /**
     * Creates new form ChangePasswordAdmin
     */
    public ChangePasswordAdmin(String username) {
        adminUsername = username;
        this.setUndecorated(true);
        this.setAlwaysOnTop(true);
        this.setResizable(false);
        this.setVisible(true);
        initComponents();
        this.setSize(890, 570);
        this.setLocationRelativeTo(null);
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
        jLabel3 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        ok = new javax.swing.JButton();
        oldPassword = new javax.swing.JPasswordField();
        newPassword = new javax.swing.JPasswordField();
        confirmPassword = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Old Password           :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(580, 140, 158, 32);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("New Password          :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(580, 240, 153, 27);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Comfirm Password      :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(580, 330, 160, 23);

        back.setBackground(new java.awt.Color(0, 0, 153));
        back.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        back.setForeground(new java.awt.Color(0, 255, 255));
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back);
        back.setBounds(590, 420, 100, 30);

        ok.setBackground(new java.awt.Color(0, 0, 153));
        ok.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ok.setForeground(new java.awt.Color(0, 255, 255));
        ok.setText("OK");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });
        getContentPane().add(ok);
        ok.setBounds(730, 420, 100, 30);

        oldPassword.setBackground(new java.awt.Color(0, 255, 255));
        oldPassword.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        oldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oldPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(oldPassword);
        oldPassword.setBounds(520, 180, 300, 30);

        newPassword.setBackground(new java.awt.Color(204, 255, 255));
        newPassword.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        getContentPane().add(newPassword);
        newPassword.setBounds(590, 270, 230, 30);

        confirmPassword.setBackground(new java.awt.Color(0, 255, 255));
        confirmPassword.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        confirmPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(confirmPassword);
        confirmPassword.setBounds(590, 360, 230, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/125.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 910, 570);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        if (!(newPassword.getText().equals("") || oldPassword.getText().equals("") || confirmPassword.getText().equals(""))) {
            String password1 = String.valueOf(newPassword.getPassword());
            String password2 = String.valueOf(confirmPassword.getPassword());
            String password3 = String.valueOf(oldPassword.getPassword());
            if (password1.equals(password2)) {

                boolean flag = changeAdminPassword(password1, password3);

                if (!flag) {
                    JOptionPane.showMessageDialog(this, "Error! Try again with correct data");

                } else {
                    JOptionPane.showMessageDialog(this, "change password successfully!");
                    this.dispose();
                    Services x = new Services(adminUsername);
                    x.setVisible(true);
                }

            } else {
                JOptionPane.showMessageDialog(this, "Please enter correct password!");
                newPassword.setText("");
                confirmPassword.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please fill all the fields!");
        }
    }//GEN-LAST:event_okActionPerformed

    private void oldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oldPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_oldPasswordActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        this.dispose();
        Services x = new Services(adminUsername);
        x.setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void confirmPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmPasswordActionPerformed
        okActionPerformed(evt);
    }//GEN-LAST:event_confirmPasswordActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JPasswordField confirmPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField newPassword;
    private javax.swing.JButton ok;
    private javax.swing.JPasswordField oldPassword;
    // End of variables declaration//GEN-END:variables

    private boolean changeAdminPassword(String password1, String password3) {
        boolean flag = false;
        Connection con;
        int rs;
        String passWord1 = SHA.getSHAPassword(password1);
        String passWord3 = SHA.getSHAPassword(password3);
        try {
            con = Database.getConnected();
            String query = "UPDATE admin_login SET password='" + passWord1 + "' "
                    + "WHERE username='" + adminUsername + "'";
            rs = Database.updateQuery(con, query);
            if (rs == 1) {
                flag = true;
            }
        } catch (SQLException | ClassNotFoundException ex) {

        }
        return flag;
    }
}
