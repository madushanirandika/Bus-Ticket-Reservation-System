/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import Includes.Database;
import Includes.InputChecker;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Login.ChangePasswordAdmin;

/**
 *
 * @author Madu Randi
 */
public class EditPersonalAdmin extends javax.swing.JFrame {

    private String adminUsername;

    /**
     * Creates new form EditPersonalAdmin
     */
    public EditPersonalAdmin(String username) {
        adminUsername = username;
        initWindow();
        addData(adminUsername);
    }

    private void initWindow() {
        this.setUndecorated(true);
        initComponents();
        this.setSize(890, 570);
        this.setAlwaysOnTop(true);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        initFields();
    }

    private void initFields() {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        name = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nicNo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        name.setBackground(new java.awt.Color(0, 255, 255));
        name.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        getContentPane().add(name);
        name.setBounds(450, 180, 240, 30);

        email.setBackground(new java.awt.Color(204, 255, 255));
        email.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        getContentPane().add(email);
        email.setBounds(450, 220, 240, 30);

        phone.setBackground(new java.awt.Color(0, 255, 255));
        phone.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        getContentPane().add(phone);
        phone.setBounds(450, 260, 240, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Full Name            :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(260, 130, 120, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Mobile Number  :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(260, 210, 130, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Email                    :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(260, 170, 120, 30);

        nicNo.setBackground(new java.awt.Color(204, 255, 255));
        nicNo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        getContentPane().add(nicNo);
        nicNo.setBounds(450, 300, 240, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("NIC Number        :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(260, 250, 130, 30);

        jButton1.setBackground(new java.awt.Color(0, 51, 153));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 255, 255));
        jButton1.setText("Change Password");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(410, 390, 150, 30);

        jButton2.setBackground(new java.awt.Color(0, 51, 153));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 255, 255));
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(260, 390, 100, 30);

        jButton3.setBackground(new java.awt.Color(0, 51, 153));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 255, 255));
        jButton3.setText("OK");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(610, 390, 85, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/125.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 890, 570);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ChangePasswordAdmin x = new ChangePasswordAdmin(adminUsername);
        x.setVisible(true);;
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        boolean[] checkInputs;
        checkInputs = checkFields();
        if (checkInputs[0] && checkInputs[1]) {
            try {
                String name1 = name.getText();
                int mobile1 = Integer.parseInt(phone.getText());
                String nic1 = nicNo.getText();
                String email1 = email.getText();

                boolean flag = editCustomerProfile(name1, email1, mobile1, nic1);

                if (!flag) {
                    JOptionPane.showMessageDialog(this, "Error! Try again ");
                } else {
                    JOptionPane.showMessageDialog(this, "Your profile updated successfully!");
                    Services x = new Services(adminUsername);
                    x.setVisible(true);
                    this.dispose();
                }
            } catch (Exception e) {
            }
        } else if (checkInputs[1]) {
            JOptionPane.showMessageDialog(this, "Please fill all the fields with valid data!");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        Services x = new Services(adminUsername);
        x.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void addData(String username) {
        try {
            Connection con;
            con = Database.getConnected();
            String query = "SELECT * FROM `admin_login` WHERE `user_name`='"
                    + username + "'";
            ResultSet rs = Database.executeQuery(con, query);
            rs.next();

            name.setText(rs.getString(1));
            phone.setText("0" + rs.getString(3));
            nicNo.setText(rs.getString(4));
            email.setText(rs.getString(2));

        } catch (SQLException | ClassNotFoundException ex) {
        }
    }

    private boolean editCustomerProfile(String name, String email, int mobile, String nic) {
        boolean flag = false;
        Connection con;
        int rs;
        try {
            con = Database.getConnected();

            String query = "UPDATE `admin_login` SET `name`='" + name + "' "
                    + ",`phone`=" + mobile + ", `nic_number` = '" + nic + "' "
                    + ",`email`= '" + email + " '"
                    + "WHERE `user_name`='" + adminUsername + "'";
            rs = Database.updateQuery(con, query);
            if (rs == 1) {
                flag = true;
            }
        } catch (SQLException | ClassNotFoundException ex) {

        }

        return flag;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField email;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField name;
    private javax.swing.JTextField nicNo;
    private javax.swing.JTextField phone;
    // End of variables declaration//GEN-END:variables

    private boolean[] checkFields() {
        boolean[] flag = new boolean[2];
        flag[0] = true;
        flag[1] = true;

        if (name.getText().equals("")) {
            flag[0] = false;
        }

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

        if (phone.getText().equals("")) {
            flag[0] = false;
        } else if (phone.getText().length() == 10) {
            if (!InputChecker.isANumber(phone.getText())) {
                flag[0] = false;
                flag[1] = false;
                JOptionPane.showMessageDialog(this, "Invalid Phone Number");
            }
        } else {
            flag[0] = false;
            flag[1] = false;
            JOptionPane.showMessageDialog(this, "Length of Pnone Number must be 10 digits");
        }

        if (nicNo.getText().equals("")) {
            flag[0] = false;
        }

        return flag;
    }
}