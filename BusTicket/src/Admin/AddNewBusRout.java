/*
 * This is a program by K.G.Sampath Sandaruwan.
 * Smcmails@gmail.com
 * 0774471293
 * Sandaruwankgs.wordpress.com
 */
package Admin;

import Includes.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author K.G.S.Sandaaruwan
 */
public class AddNewBusRout extends javax.swing.JFrame {

    private String adminUsername;

    /**
     * Creates new form AddNewBusRout
     */
    public AddNewBusRout(String username) {
        adminUsername = username;
        initWindow();
    }

    public AddNewBusRout(String username, String[] argsString) {
        adminUsername = username;
        initWindow();
        initFields(argsString);
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

    private void initFields(String[] argsString) {
        routNumber.setText(argsString[0]);
        from.setText(argsString[1]);
        to.setText(argsString[2]);
        distance.setText(argsString[3]);
        fee.setText(argsString[4]);
        duration.setText(argsString[5]);
        halts.setText(argsString[6]);
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
        routNumber = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        from = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        to = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        distance = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        fee = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        duration = new javax.swing.JTextField();
        back = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        ok = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        halts = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(890, 570));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Route Number");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(120, 130, 200, 30);

        routNumber.setBackground(new java.awt.Color(0, 255, 255));
        routNumber.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        routNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                routNumberActionPerformed(evt);
            }
        });
        getContentPane().add(routNumber);
        routNumber.setBounds(370, 130, 200, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Between");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(120, 180, 200, 30);

        from.setBackground(new java.awt.Color(204, 255, 255));
        from.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        from.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromActionPerformed(evt);
            }
        });
        getContentPane().add(from);
        from.setBounds(370, 180, 200, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("and");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(578, 180, 40, 30);

        to.setBackground(new java.awt.Color(204, 255, 255));
        to.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        to.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toActionPerformed(evt);
            }
        });
        getContentPane().add(to);
        to.setBounds(620, 180, 200, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Total Distance (km)");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(120, 230, 200, 30);

        distance.setBackground(new java.awt.Color(0, 255, 255));
        distance.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        distance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                distanceActionPerformed(evt);
            }
        });
        getContentPane().add(distance);
        distance.setBounds(370, 230, 200, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Maximum Bus Fee (Rs.)");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(120, 280, 200, 30);

        fee.setBackground(new java.awt.Color(204, 255, 255));
        fee.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        fee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                feeActionPerformed(evt);
            }
        });
        getContentPane().add(fee);
        fee.setBounds(370, 280, 200, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Route Running Time in Minutes");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(120, 320, 200, 30);

        duration.setBackground(new java.awt.Color(0, 255, 255));
        duration.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        duration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                durationActionPerformed(evt);
            }
        });
        getContentPane().add(duration);
        duration.setBounds(370, 320, 200, 30);

        back.setBackground(new java.awt.Color(0, 51, 153));
        back.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        back.setForeground(new java.awt.Color(0, 255, 255));
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back);
        back.setBounds(50, 490, 100, 30);

        clear.setBackground(new java.awt.Color(0, 51, 153));
        clear.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        clear.setForeground(new java.awt.Color(0, 255, 255));
        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        getContentPane().add(clear);
        clear.setBounds(370, 490, 100, 30);

        ok.setBackground(new java.awt.Color(0, 51, 153));
        ok.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ok.setForeground(new java.awt.Color(0, 255, 255));
        ok.setText("Ok");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });
        getContentPane().add(ok);
        ok.setBounds(730, 490, 100, 30);
        ok.getAccessibleContext().setAccessibleName("OK");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Number Of main Halts in Rout");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(120, 370, 200, 30);

        halts.setBackground(new java.awt.Color(204, 255, 255));
        halts.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        halts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                haltsActionPerformed(evt);
            }
        });
        getContentPane().add(halts);
        halts.setBounds(370, 370, 200, 30);

        jLabel8.setBackground(new java.awt.Color(0, 51, 153));
        jLabel8.setForeground(new java.awt.Color(0, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/125.jpg"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(0, 0, 890, 570);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        Services x = new Services(adminUsername);
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        routNumber.setText("");
        from.setText("");
        to.setText("");
        distance.setText("");
        fee.setText("");
        duration.setText("");
        halts.setText("");
    }//GEN-LAST:event_clearActionPerformed

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        boolean exist = true;
        try {
            Connection con = Database.getConnected();
            String query = "SELECT * FROM `rout_data` WHERE "
                    + "`rout_number`='" + routNumber.getText() + "'";
            ResultSet rs = Database.executeQuery(con, query);
            if (!rs.next()) {
                exist = false;
            } else {
                JOptionPane.showMessageDialog(this, "The rout number you entered "
                        + "is already exist. If you have two rout in same rout "
                        + "number,\nYou just enter the data about longest rout "
                        + "and you can assing busses for shorter routes\n"
                        + "also by using that enterd route data.");
                exist = true;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        if (filled() && !exist) {
            String routNumber = this.routNumber.getText();
            String from = this.from.getText();
            String to = this.to.getText();
            String distance = this.distance.getText();
            String fee = this.fee.getText();
            String duration = this.duration.getText();
            String halts = this.halts.getText();

            if (!from.equalsIgnoreCase(to)) {
                int turnDistance, turnFee, turnDuration, turnHalts;

                try {
                    turnDistance = Integer.parseInt(distance);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Enter distance as apositive integer");
                    turnDistance = 0;
                }
                if (turnDistance > 0) {
                    try {
                        turnFee = Integer.parseInt(fee);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, "Enter Maximum bus fee as apositive integer");
                        turnFee = 0;
                    }
                    if (turnFee > 0) {
                        try {
                            turnDuration = Integer.parseInt(duration);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(this, "Enter Maximum bus fee as apositive integer");
                            turnDuration = 0;
                        }
                        if (turnDuration > 0) {
                            try {
                                turnHalts = Integer.parseInt(halts);
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(this, "Enter number of halts as apositive integer");
                                turnHalts = 0;
                            }
                            if (turnHalts > 0) {
                                String[] argsString = {routNumber, from, to};
                                int[] argsInt = {turnDistance, turnFee, turnDuration, turnHalts};
                                HaltDistanceInput x = new HaltDistanceInput(adminUsername, argsString, argsInt);
                                this.dispose();
                            }
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Start and Stop of bus cannot be same.");
            }
        } else if(!exist){
            JOptionPane.showMessageDialog(this, "All fields must be filled");
        }
    }//GEN-LAST:event_okActionPerformed

    private void haltsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_haltsActionPerformed
        okActionPerformed(evt);
    }//GEN-LAST:event_haltsActionPerformed

    private void durationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_durationActionPerformed
        halts.requestFocusInWindow();
    }//GEN-LAST:event_durationActionPerformed

    private void feeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_feeActionPerformed
        duration.requestFocusInWindow();
    }//GEN-LAST:event_feeActionPerformed

    private void distanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_distanceActionPerformed
        fee.requestFocusInWindow();
    }//GEN-LAST:event_distanceActionPerformed

    private void toActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toActionPerformed
        distance.requestFocusInWindow();
    }//GEN-LAST:event_toActionPerformed

    private void fromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fromActionPerformed
        to.requestFocusInWindow();
    }//GEN-LAST:event_fromActionPerformed

    private void routNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_routNumberActionPerformed
        from.requestFocusInWindow();
    }//GEN-LAST:event_routNumberActionPerformed

    private boolean filled() {
        boolean flag = true;
        if ("".equals(routNumber.getText())) {
            flag = false;
        }
        if ("".equals(from.getText())) {
            flag = false;
        }
        if ("".equals(to.getText())) {
            flag = false;
        }
        if ("".equals(distance.getText())) {
            flag = false;
        }
        if ("".equals(fee.getText())) {
            flag = false;
        }
        if ("".equals(duration.getText())) {
            flag = false;
        }
        if ("".equals(halts.getText())) {
            flag = false;
        }
        return flag;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton clear;
    private javax.swing.JTextField distance;
    private javax.swing.JTextField duration;
    private javax.swing.JTextField fee;
    private javax.swing.JTextField from;
    private javax.swing.JTextField halts;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton ok;
    private javax.swing.JTextField routNumber;
    private javax.swing.JTextField to;
    // End of variables declaration//GEN-END:variables
}