/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Includes.Database;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author HansiPC
 */
public class FpLogin extends javax.swing.JFrame {

    /**
     * Creates new form FpLogging
     */
    public FpLogin() {
        initWindow();
    }

    private void initWindow() {
        this.setUndecorated(true);
        initComponents();
        this.setSize(890, 570);
        this.setAlwaysOnTop(true);
        this.setResizable(false);
        this.setVisible(true);
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
        email = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nicNo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        mobileNo = new javax.swing.JFormattedTextField();
        back = new javax.swing.JButton();
        ok = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Email      :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(550, 80, 180, 24);

        email.setBackground(new java.awt.Color(153, 255, 0));
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        getContentPane().add(email);
        email.setBounds(550, 110, 300, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NIC No    :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(550, 160, 190, 28);

        nicNo.setBackground(new java.awt.Color(153, 255, 102));
        nicNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nicNoActionPerformed(evt);
            }
        });
        getContentPane().add(nicNo);
        nicNo.setBounds(550, 200, 300, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mobile No  :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(550, 260, 190, 31);

        mobileNo.setBackground(new java.awt.Color(153, 255, 0));
        mobileNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobileNoActionPerformed(evt);
            }
        });
        getContentPane().add(mobileNo);
        mobileNo.setBounds(550, 300, 300, 30);

        back.setBackground(new java.awt.Color(0, 0, 0));
        back.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        back.setForeground(new java.awt.Color(102, 255, 0));
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back);
        back.setBounds(550, 380, 90, 30);

        ok.setBackground(new java.awt.Color(0, 0, 0));
        ok.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ok.setForeground(new java.awt.Color(102, 255, 0));
        ok.setText("OK");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });
        getContentPane().add(ok);
        ok.setBounds(770, 380, 80, 30);

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 255, 0));
        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(660, 380, 90, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/02.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 890, 570);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        boolean[] checkInputs;
        checkInputs = checkFields();
        if (checkInputs[0]) {
            String email = this.email.getText();
            String nic = nicNo.getText();
            int mobile = 0;
            try {
                mobile = Integer.parseInt(mobileNo.getText());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Enter only digits as mobile number");
            }
            boolean result = forgotPassword(email, nic, mobile);
            if (result) {
                ResetPassword x = new ResetPassword(email);
                x.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Wrong enter details");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please fill all the fields");
        }
    }//GEN-LAST:event_okActionPerformed

    private boolean[] checkFields() {
        boolean[] flag = new boolean[2];
        flag[0] = true;
        flag[1] = true;

        if (email.getText().equals("")) {
            flag[0] = false;
        } else {
            try {
                String[] emailParts = email.getText().split("@");
                if (emailParts.length != 2) {
                    flag[0] = false;
                    flag[1] = false;
                    JOptionPane.showMessageDialog(this, "Invalid email.");
                }
            } catch (Exception ex) {
                flag[0] = false;
                flag[1] = false;
                JOptionPane.showMessageDialog(this, "Invalid email.");
            }
        }

        if (mobileNo.getText().equals("")) {
            flag[0] = false;
        } else {
            if (mobileNo.getText().length() != 10) {
                flag[0] = false;
                flag[1] = false;
                JOptionPane.showMessageDialog(this, "Length of Mobile shold be 10 digits");
            } else {
                try {
                    int number = Integer.parseInt(mobileNo.getText());
                } catch (Exception ex) {
                    flag[0] = false;
                    flag[1] = false;
                    JOptionPane.showMessageDialog(this, "Mobile is only allowed numbers only");
                }
            }
        }

        if (nicNo.getText().equals("")) {
            flag[0] = false;
        }

        return flag;
    }
    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        Startup x = new Startup();
        this.dispose();
        x.setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void mobileNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobileNoActionPerformed
        okActionPerformed(evt);
    }//GEN-LAST:event_mobileNoActionPerformed

    private void nicNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nicNoActionPerformed
        okActionPerformed(evt);
    }//GEN-LAST:event_nicNoActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        okActionPerformed(evt);
    }//GEN-LAST:event_emailActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        email.setText("");
        nicNo.setText("");
        mobileNo.setText("");
        email.requestFocus();
    }//GEN-LAST:event_jButton1ActionPerformed

    
    private boolean forgotPassword(String email, String nic, int mobile) {

        boolean flag = false;
        try {
            Connection con = Database.getConnected();
            String query = "SELECT email, nic_number,phone FROM customer_login WHERE "
                    + "email='" + email + "' AND phone='" + mobile + "' AND nic_number='" + nic + "'";
            ResultSet rs = Database.executeQuery(con, query);
            flag = rs.next();
        } catch (SQLException | ClassNotFoundException ex) {
        }
        return flag;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JTextField email;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JFormattedTextField mobileNo;
    private javax.swing.JTextField nicNo;
    private javax.swing.JButton ok;
    // End of variables declaration//GEN-END:variables
}
