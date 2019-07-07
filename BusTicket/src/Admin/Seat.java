/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import Includes.Database;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author HansiPC
 */
public class Seat extends javax.swing.JFrame {

    private String adminUsername;
    private JTextField[][] busSeats;
    private boolean newBus;
    private String busName, busNumber, numberOfSeats, transportLicenseNumber, hotline, seatConfig;

    /**
     * Creates new form Seat
     */
    public Seat(String username, String[] busData) {
        adminUsername = username;
        initWindow();
        if (busData.length == 2) {
            newBus = false;
            busNumber = busData[0];
            seatConfig = busData[1];
            try {
                numberOfSeats = getNumberOfSeats();
            } catch (SQLException | ClassNotFoundException ex) {
            }
            try {
                if (seatConfig == null) {
                    loadPreviousSeatConfig(busData[0]);
                }
            } catch (SQLException | ClassNotFoundException ex) {
            }
        } else if (busData.length == 6) {
            newBus = true;
            busName = busData[0];
            busNumber = busData[1];
            numberOfSeats = busData[2];
            transportLicenseNumber = busData[3];
            hotline = busData[4];
            seatConfig = busData[5];
        }
        if (seatConfig != null) {
            try {
                loadPreviousSeatConfig(seatConfig);
            } catch (SQLException | ClassNotFoundException ex) {
            }
        }
        numOfSeats.setText(numberOfSeats);
    }

    private void initWindow() {
        this.setUndecorated(true);
        initComponents();
        this.setSize(890, 570);
        this.setAlwaysOnTop(false);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        createArray();
        jTextField6.requestFocusInWindow();
        numOfSeats.setVisible(false);
        numOfSeatsLabel.setVisible(false);
    }

    private void createArray() {
        busSeats = new JTextField[][]{
            {jTextField1, jTextField2, jTextField3, jTextField4, jTextField5, jTextField6},
            {jTextField7, jTextField8, jTextField9, jTextField10, jTextField11, jTextField12},
            {jTextField13, jTextField14, jTextField15, jTextField16, jTextField17, jTextField18},
            {jTextField19, jTextField20, jTextField21, jTextField22, jTextField23, jTextField24},
            {jTextField25, jTextField26, jTextField27, jTextField28, jTextField29, jTextField30},
            {jTextField31, jTextField32, jTextField33, jTextField34, jTextField35, jTextField36},
            {jTextField37, jTextField38, jTextField39, jTextField40, jTextField41, jTextField42},
            {jTextField43, jTextField44, jTextField45, jTextField46, jTextField47, jTextField48},
            {jTextField49, jTextField50, jTextField51, jTextField52, jTextField53, jTextField54},
            {jTextField55, jTextField56, jTextField57, jTextField58, jTextField59, jTextField60},
            {jTextField61, jTextField62, jTextField63, jTextField64, jTextField65, jTextField66},
            {jTextField67, jTextField68, jTextField69, jTextField70, jTextField71, jTextField72}};

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                busSeats[i][j].setText("");
            }
        }
    }

    private String getNumberOfSeats() throws SQLException, ClassNotFoundException {
        Connection con = Database.getConnected();
        String query = "SELECT * FROM `bus_data` WHERE bus_number='" + busNumber + "'";
        ResultSet rs = Database.executeQuery(con, query);
        rs.next();
        return rs.getString(3);
    }

    private void loadPreviousSeatConfig(String param) throws SQLException, ClassNotFoundException {
        Connection con = Database.getConnected();
        String query = "SELECT * FROM `bus_data` WHERE bus_number='" + param + "'";
        ResultSet rs = Database.executeQuery(con, query);
        String seatConfig;
        if (rs.next()) {
            seatConfig = rs.getString(6);
        } else {
            seatConfig = param;
        }
        String[] seatRows = seatConfig.split("/");
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                String[] rowSeats = seatRows[i].split("-");
                if (!"  ".equals(rowSeats[j])) {
                    busSeats[i][j].setText(rowSeats[j]);
                } else {
                    busSeats[i][j].setText("");
                }
            }
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

        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jTextField25 = new javax.swing.JTextField();
        jTextField26 = new javax.swing.JTextField();
        jTextField27 = new javax.swing.JTextField();
        jTextField28 = new javax.swing.JTextField();
        jTextField29 = new javax.swing.JTextField();
        jTextField30 = new javax.swing.JTextField();
        jTextField31 = new javax.swing.JTextField();
        jTextField32 = new javax.swing.JTextField();
        jTextField33 = new javax.swing.JTextField();
        jTextField34 = new javax.swing.JTextField();
        jTextField35 = new javax.swing.JTextField();
        jTextField36 = new javax.swing.JTextField();
        jTextField37 = new javax.swing.JTextField();
        jTextField38 = new javax.swing.JTextField();
        jTextField39 = new javax.swing.JTextField();
        jTextField40 = new javax.swing.JTextField();
        jTextField41 = new javax.swing.JTextField();
        jTextField42 = new javax.swing.JTextField();
        jTextField43 = new javax.swing.JTextField();
        jTextField44 = new javax.swing.JTextField();
        jTextField45 = new javax.swing.JTextField();
        jTextField46 = new javax.swing.JTextField();
        jTextField47 = new javax.swing.JTextField();
        jTextField48 = new javax.swing.JTextField();
        jTextField49 = new javax.swing.JTextField();
        jTextField50 = new javax.swing.JTextField();
        jTextField51 = new javax.swing.JTextField();
        jTextField52 = new javax.swing.JTextField();
        jTextField53 = new javax.swing.JTextField();
        jTextField54 = new javax.swing.JTextField();
        jTextField55 = new javax.swing.JTextField();
        jTextField56 = new javax.swing.JTextField();
        jTextField57 = new javax.swing.JTextField();
        jTextField58 = new javax.swing.JTextField();
        jTextField59 = new javax.swing.JTextField();
        jTextField60 = new javax.swing.JTextField();
        jTextField61 = new javax.swing.JTextField();
        jTextField62 = new javax.swing.JTextField();
        jTextField63 = new javax.swing.JTextField();
        jTextField64 = new javax.swing.JTextField();
        jTextField65 = new javax.swing.JTextField();
        jTextField66 = new javax.swing.JTextField();
        jTextField67 = new javax.swing.JTextField();
        jTextField68 = new javax.swing.JTextField();
        jTextField69 = new javax.swing.JTextField();
        jTextField70 = new javax.swing.JTextField();
        jTextField71 = new javax.swing.JTextField();
        jTextField72 = new javax.swing.JTextField();
        back = new javax.swing.JButton();
        ok = new javax.swing.JButton();
        doors = new javax.swing.JLabel();
        front = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        numOfSeatsLabel = new javax.swing.JLabel();
        numOfSeats = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(100, 410, 40, 30);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(100, 360, 40, 30);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(100, 310, 40, 30);
        getContentPane().add(jTextField4);
        jTextField4.setBounds(100, 260, 40, 30);
        getContentPane().add(jTextField5);
        jTextField5.setBounds(100, 210, 40, 30);
        getContentPane().add(jTextField6);
        jTextField6.setBounds(100, 160, 40, 30);
        getContentPane().add(jTextField7);
        jTextField7.setBounds(160, 410, 40, 30);
        getContentPane().add(jTextField8);
        jTextField8.setBounds(160, 360, 40, 30);
        getContentPane().add(jTextField9);
        jTextField9.setBounds(160, 310, 40, 30);
        getContentPane().add(jTextField10);
        jTextField10.setBounds(160, 260, 40, 30);
        getContentPane().add(jTextField11);
        jTextField11.setBounds(160, 210, 40, 30);
        getContentPane().add(jTextField12);
        jTextField12.setBounds(160, 160, 40, 30);
        getContentPane().add(jTextField13);
        jTextField13.setBounds(220, 410, 40, 30);
        getContentPane().add(jTextField14);
        jTextField14.setBounds(220, 360, 40, 30);
        getContentPane().add(jTextField15);
        jTextField15.setBounds(220, 310, 40, 30);
        getContentPane().add(jTextField16);
        jTextField16.setBounds(220, 260, 40, 30);
        getContentPane().add(jTextField17);
        jTextField17.setBounds(220, 210, 40, 30);
        getContentPane().add(jTextField18);
        jTextField18.setBounds(220, 160, 40, 30);
        getContentPane().add(jTextField19);
        jTextField19.setBounds(280, 410, 40, 30);
        getContentPane().add(jTextField20);
        jTextField20.setBounds(280, 360, 40, 30);
        getContentPane().add(jTextField21);
        jTextField21.setBounds(280, 310, 40, 30);
        getContentPane().add(jTextField22);
        jTextField22.setBounds(280, 260, 40, 30);
        getContentPane().add(jTextField23);
        jTextField23.setBounds(280, 210, 40, 30);
        getContentPane().add(jTextField24);
        jTextField24.setBounds(280, 160, 40, 30);
        getContentPane().add(jTextField25);
        jTextField25.setBounds(340, 410, 40, 30);
        getContentPane().add(jTextField26);
        jTextField26.setBounds(340, 360, 40, 30);
        getContentPane().add(jTextField27);
        jTextField27.setBounds(340, 310, 40, 30);
        getContentPane().add(jTextField28);
        jTextField28.setBounds(340, 260, 40, 30);
        getContentPane().add(jTextField29);
        jTextField29.setBounds(340, 210, 40, 30);
        getContentPane().add(jTextField30);
        jTextField30.setBounds(340, 160, 40, 30);
        getContentPane().add(jTextField31);
        jTextField31.setBounds(400, 410, 40, 30);
        getContentPane().add(jTextField32);
        jTextField32.setBounds(400, 360, 40, 30);
        getContentPane().add(jTextField33);
        jTextField33.setBounds(400, 310, 40, 30);
        getContentPane().add(jTextField34);
        jTextField34.setBounds(400, 260, 40, 30);
        getContentPane().add(jTextField35);
        jTextField35.setBounds(400, 210, 40, 30);
        getContentPane().add(jTextField36);
        jTextField36.setBounds(400, 160, 40, 30);
        getContentPane().add(jTextField37);
        jTextField37.setBounds(460, 410, 40, 30);
        getContentPane().add(jTextField38);
        jTextField38.setBounds(460, 360, 40, 30);
        getContentPane().add(jTextField39);
        jTextField39.setBounds(460, 310, 40, 30);
        getContentPane().add(jTextField40);
        jTextField40.setBounds(460, 260, 40, 30);
        getContentPane().add(jTextField41);
        jTextField41.setBounds(460, 210, 40, 30);
        getContentPane().add(jTextField42);
        jTextField42.setBounds(460, 160, 40, 30);
        getContentPane().add(jTextField43);
        jTextField43.setBounds(520, 410, 40, 30);
        getContentPane().add(jTextField44);
        jTextField44.setBounds(520, 360, 40, 30);
        getContentPane().add(jTextField45);
        jTextField45.setBounds(520, 310, 40, 30);
        getContentPane().add(jTextField46);
        jTextField46.setBounds(520, 260, 40, 30);
        getContentPane().add(jTextField47);
        jTextField47.setBounds(520, 210, 40, 30);
        getContentPane().add(jTextField48);
        jTextField48.setBounds(520, 160, 40, 30);
        getContentPane().add(jTextField49);
        jTextField49.setBounds(580, 410, 40, 30);
        getContentPane().add(jTextField50);
        jTextField50.setBounds(580, 360, 40, 30);
        getContentPane().add(jTextField51);
        jTextField51.setBounds(580, 310, 40, 30);
        getContentPane().add(jTextField52);
        jTextField52.setBounds(580, 260, 40, 30);
        getContentPane().add(jTextField53);
        jTextField53.setBounds(580, 210, 40, 30);
        getContentPane().add(jTextField54);
        jTextField54.setBounds(580, 160, 40, 30);
        getContentPane().add(jTextField55);
        jTextField55.setBounds(640, 410, 40, 30);
        getContentPane().add(jTextField56);
        jTextField56.setBounds(640, 360, 40, 30);
        getContentPane().add(jTextField57);
        jTextField57.setBounds(640, 310, 40, 30);
        getContentPane().add(jTextField58);
        jTextField58.setBounds(640, 260, 40, 30);
        getContentPane().add(jTextField59);
        jTextField59.setBounds(640, 210, 40, 30);
        getContentPane().add(jTextField60);
        jTextField60.setBounds(640, 160, 40, 30);
        getContentPane().add(jTextField61);
        jTextField61.setBounds(700, 410, 40, 30);
        getContentPane().add(jTextField62);
        jTextField62.setBounds(700, 360, 40, 30);
        getContentPane().add(jTextField63);
        jTextField63.setBounds(700, 310, 40, 30);
        getContentPane().add(jTextField64);
        jTextField64.setBounds(700, 260, 40, 30);
        getContentPane().add(jTextField65);
        jTextField65.setBounds(700, 210, 40, 30);
        getContentPane().add(jTextField66);
        jTextField66.setBounds(700, 160, 40, 30);
        getContentPane().add(jTextField67);
        jTextField67.setBounds(760, 410, 40, 30);
        getContentPane().add(jTextField68);
        jTextField68.setBounds(760, 360, 40, 30);
        getContentPane().add(jTextField69);
        jTextField69.setBounds(760, 310, 40, 30);
        getContentPane().add(jTextField70);
        jTextField70.setBounds(760, 260, 40, 30);
        getContentPane().add(jTextField71);
        jTextField71.setBounds(760, 210, 40, 30);
        getContentPane().add(jTextField72);
        jTextField72.setBounds(760, 160, 40, 30);

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
        back.setBounds(30, 510, 100, 30);

        ok.setBackground(new java.awt.Color(0, 51, 153));
        ok.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ok.setForeground(new java.awt.Color(0, 255, 255));
        ok.setText("OK");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });
        getContentPane().add(ok);
        ok.setBounds(710, 510, 100, 30);

        doors.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bus.jpg"))); // NOI18N
        doors.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(doors);
        doors.setBounds(30, 450, 780, 50);

        front.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bus.jpg"))); // NOI18N
        front.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(front);
        front.setBounds(30, 150, 60, 350);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Note: - There are 12 columns and 6 rows here. Assume this as the top view of your bus and enter seat numbers of your bus into \n\tthese cells. You can use [TAB] button for surf through these cells. Please be careful to only enter numbers in these \n\tcells. Other data rather than numbers will be automatically removed.");
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 70, 770, 70);

        numOfSeatsLabel.setText("Number Of Seats    :");
        getContentPane().add(numOfSeatsLabel);
        numOfSeatsLabel.setBounds(494, 510, 130, 30);

        numOfSeats.setBackground(new java.awt.Color(0, 255, 255));
        numOfSeats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numOfSeatsActionPerformed(evt);
            }
        });
        getContentPane().add(numOfSeats);
        numOfSeats.setBounds(620, 510, 80, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/125.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-10, -20, 1010, 620);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        boolean allAreNumbers = true;
        String seats = "";
        int largestSeatNumber = 0, numberOfAcceptedSeats = 0;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                try {
                    if (!("".equals(busSeats[i][j].getText()) || "  ".equals(busSeats[i][j].getText()))) {
                        int n = Integer.parseInt(busSeats[i][j].getText());
                        if (n > largestSeatNumber) {
                            largestSeatNumber = n;
                        }
                        if (n < 10) {
                            busSeats[i][j].setText("0" + n);
                        }
                        numberOfAcceptedSeats++;
                    } else {
                        busSeats[i][j].setText("  ");
                    }
                } catch (Exception ex) {
                    allAreNumbers = false;
                    busSeats[i][j].setText("");
                    JOptionPane.showMessageDialog(this, "Enter only seat numbers in boxes");
                }
                seats += busSeats[i][j].getText() + "-";
            }
            seats += "/";
        }
        if (allAreNumbers) {
            int numberOfSeatsInt = Integer.parseInt(numOfSeats.getText());
            if (largestSeatNumber == numberOfSeatsInt
                    && numberOfSeatsInt == numberOfAcceptedSeats) {
                if (newBus) {
                    String[] args = {busName, busNumber, numOfSeats.getText(), transportLicenseNumber, hotline, seats};
                    FullReview x = new FullReview(adminUsername, args);
                    x.setVisible(true);
                } else {
                    String[] args = {busNumber, numOfSeats.getText(), seats};
                    FullReview x = new FullReview(adminUsername, args);
                    x.setVisible(true);
                }
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Number of seats  doesn't "
                        + "match with entered data. Please check them again.");
                numOfSeats.setVisible(true);
                numOfSeatsLabel.setVisible(true);
                for (int i = 0; i < 12; i++) {
                    for (int j = 0; j < 6; j++) {
                        if ("  ".equals(busSeats[i][j].getText())) {
                            busSeats[i][j].setText("");
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_okActionPerformed

    private void numOfSeatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numOfSeatsActionPerformed
        okActionPerformed(evt);
    }//GEN-LAST:event_numOfSeatsActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        if (newBus) {
            String[] args = {busName, busNumber, numberOfSeats, transportLicenseNumber, hotline};
            AddNewBus x = new AddNewBus(adminUsername, args);
            x.setVisible(true);
            this.dispose();
        } else {
            EditBus x = new EditBus(busNumber);
            x.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_backActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel doors;
    private javax.swing.JLabel front;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField41;
    private javax.swing.JTextField jTextField42;
    private javax.swing.JTextField jTextField43;
    private javax.swing.JTextField jTextField44;
    private javax.swing.JTextField jTextField45;
    private javax.swing.JTextField jTextField46;
    private javax.swing.JTextField jTextField47;
    private javax.swing.JTextField jTextField48;
    private javax.swing.JTextField jTextField49;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField50;
    private javax.swing.JTextField jTextField51;
    private javax.swing.JTextField jTextField52;
    private javax.swing.JTextField jTextField53;
    private javax.swing.JTextField jTextField54;
    private javax.swing.JTextField jTextField55;
    private javax.swing.JTextField jTextField56;
    private javax.swing.JTextField jTextField57;
    private javax.swing.JTextField jTextField58;
    private javax.swing.JTextField jTextField59;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField60;
    private javax.swing.JTextField jTextField61;
    private javax.swing.JTextField jTextField62;
    private javax.swing.JTextField jTextField63;
    private javax.swing.JTextField jTextField64;
    private javax.swing.JTextField jTextField65;
    private javax.swing.JTextField jTextField66;
    private javax.swing.JTextField jTextField67;
    private javax.swing.JTextField jTextField68;
    private javax.swing.JTextField jTextField69;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField70;
    private javax.swing.JTextField jTextField71;
    private javax.swing.JTextField jTextField72;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField numOfSeats;
    private javax.swing.JLabel numOfSeatsLabel;
    private javax.swing.JButton ok;
    // End of variables declaration//GEN-END:variables
}
